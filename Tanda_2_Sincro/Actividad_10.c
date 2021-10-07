//Actividad_10.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>

void manejador (int signal ) // Gestion de señales en proceso Padre   
{
	printf ("Padre recibe señal...%d\n", signal); // Mensaje a imprimir cada vez que llegue una señal
}

void main ()
{ 
	int pid_hijo;
	pid_hijo = fork(); // creamos el hijo
	switch (pid_hijo) {
    	case -1: // error
		    printf("No se ha podido crear el proceso hijo...\n");
		    exit (-1);
		    break;
    	case 0:   // El hijo envia 3 señales al padre
		    sleep (1);
		    kill (getppid(), SIGUSR1); //Envía señal al padre
		    sleep (1);
		    kill (getppid(), SIGUSR1); //Envía señal al padre
		    sleep (1);
            kill (getppid(), SIGUSR1); //Envía señal al padre
		    sleep (1);
            kill (getppid(), SIGKILL); // Mata el proceso
		    break;
	default: // El padre
            signal (SIGUSR1, manejador); // Manejador de señal en padre
		    while(1) {}; // Bucle infinito
		    break;
	}
	exit(0);
}