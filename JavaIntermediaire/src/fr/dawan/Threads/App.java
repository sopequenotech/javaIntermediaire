package fr.dawan.Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	// Ressource partagée
	static int total = 0;

	public static void main(String[] args) throws Exception {
		// Processus: un programme en cours d'exécution - qui enveloppe au minimum 1
		// thread
		// Thread: unité physique d'exécution d'une tâche
		// Par defaut un Thread est associé à une application - main thread
		// Par defaut une application ne peut exécuter qu'une seule tâche à la fois -
		// application mono thread

		// System.out.println(Thread.currentThread().getName());

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Tâche1..........");

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Tâche2......");

			}
		});

		t1.start();
		t2.start();

		t1.join(); // met en attente le thread principal
		t2.join();

		System.out.println("Tâche principale..........");

		System.out.println(">>>>> Gestion de l'accès conccurrentiel à une ressource partagée:");

		Thread th1 = new Thread(App::AddMillion);
		Thread th2 = new Thread(App::AddMillion);
		Thread th3 = new Thread(App::AddMillion);

		th1.start();
		th2.start();
		th3.start();

		th1.join();
		th2.join();
		th3.join();

		System.out.println("Total = " + total);

		// Lancer 2 copies de fichiers en parallèle
		String src1 = "a.txt";
		String src2 = "b.txt";

		String cible1 = "c.txt";
		String cible2 = "d.txt";

		Thread copy1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					FileTool.copy(src1, cible1);
					System.out.println("Copie1--------------"+Thread.currentThread().getName());
				} catch (Exception e) {

					e.printStackTrace();
				}

			}
		});

		Thread copy2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					FileTool.copy(src2, cible2);
					System.out.println("Copie2--------------"+Thread.currentThread().getName());
				} catch (Exception e) {

					e.printStackTrace();
				}

			}
		});
		
		//copy1.start();
		//copy2.start();
		
		String src3 = "a.txt";
		String src4 = "b.txt";
		
		String cible3 = "e.txt";
		String cible4 = "f.txt";
		
		Thread copy3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					FileTool.copy(src3, cible3);
					System.out.println("Copie3--------------"+Thread.currentThread().getName());
				} catch (Exception e) {

					e.printStackTrace();
				}

			}
		});
		
		Thread copy4 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					FileTool.copy(src4, cible4);
					System.out.println("Copie4--------------"+Thread.currentThread().getName());
				} catch (Exception e) {

					e.printStackTrace();
				}

			}
		});
		
		//copier 100 fichiers en parallel
		//Java nous propose la possibilité de créer un réservoir de thread - un pool de thread
		
		//Si aucun Thread d'est disponible pour exécuter la tâche, elle sera mise en attente dans une file gérée par le pool
		
		ExecutorService service = Executors.newFixedThreadPool(2); //un pool de 2 thread
		service.execute(copy1);
		service.execute(copy2);
		service.execute(copy3);
		service.execute(copy4);
		
		service.shutdown(); //libérer les threads monopolisés par le pool
		
		//Exécuter une tâche dans Thread et récupérer le résultat:
		
		int x = 10;
		int y = 15;
		int resultat = 0;
		
		ExecutorService pool = Executors.newFixedThreadPool(1);
		Future<Integer> future = pool.submit(new Callable<Integer>() {
									@Override
									public Integer call() throws Exception {
										Thread.sleep(2000); //pause de 2 secondes pour simuler une tâche lente
										return x + y;
									}
								});
		
		//Comment savoir que la tâche asynchrone à fini  son exécution
		//Vérifier si tâche est finie: équivalent de await en c#
		while(!future.isDone()) {
			System.out.println("Tâche en cours........");
		}
		
		
		resultat = future.get();
		System.out.println("Resultat = "+resultat);
		pool.shutdown();
		

	}

	// Synchronized: demande au Thread qui exécute de vérrouiller l'accèes au code
	// de la méthode
	public synchronized static void AddMillion() {
		for (int i = 0; i < 1000000; i++) {
			total++;
		}
	}

}
