package reflection;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MazeSolver {

	Maze maze;
	IMazeSolver solver;

	public MazeSolver(Maze _maze, IMazeSolver _solver) {
		maze = _maze;
		solver = _solver;
	}

	void solve(){
		while(!maze.isSolved()){
			Direction d = solver.advance(maze.getpx(), maze.getpy(), maze.getNeighborhood());
			if(d==Direction.STOP){
				System.out.println("Impossible");
				return;
			}
			maze.move(d);
			maze.printMaze();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Solved");
	}


	public static List<Class> loadSolversfromJar(String pathToJar){
		List<Class> solversInJar = new ArrayList();
		JarFile jarFile;
		try {
			jarFile = new JarFile(pathToJar);

			Enumeration<JarEntry> e = jarFile.entries();

			URL[] urls = { new URL("jar:file:" + pathToJar+"!/") };
			URLClassLoader cl = URLClassLoader.newInstance(urls);

			while (e.hasMoreElements()) {
				JarEntry je = e.nextElement();
				if(je.isDirectory() || !je.getName().endsWith(".class")){
					continue;
				}
				// -6 because of .class
				String className = je.getName().substring(0,je.getName().length()-6);
				className = className.replace('/', '.');
				if(className.contains("Solver")){
					Class c = cl.loadClass(className);
					solversInJar.add(c);
				}

			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return solversInJar;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Path of the jar containing the solvers...");
		String s = scanner.nextLine();
		List<Class> solvers = MazeSolver.loadSolversfromJar(s);
		Maze m = new Maze(10, 0, 0,0.35f);
		
		
		for(Class cc : solvers){
			m.initMaze();
			if(cc.isInterface())
				continue;
			System.out.println(cc.getName());
			IMazeSolver classsolver;
			try {
				classsolver = (IMazeSolver) cc.newInstance();
			
			MazeSolver solver = new MazeSolver(m,classsolver ); 
			solver.solve();
			
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
