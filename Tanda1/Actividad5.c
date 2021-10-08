//Tanda 1, Actividad 5: Programa que genere una sucesion de n hijos y nietos
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
void main()
{
    pid_t pid, pidPadre;
    int hijos = 8;

    pid = fork(); // Se crea el primer hijo
    for (int i = 1; i < hijos; i++)
    {    
        switch(pid)
		{
			case -1: // Aqui entra si ha fallado la creacion del padre
				printf("No se ha podido crear al hijo %d\n", i);
				exit(-1); 
			case 0: // Aqui entramos en el hijo
				printf("Soy el hijo %d, Mi padre es %d y mi PID es %d\n", i, getppid(), getpid());
				pid = fork(); // Creamos un hijo al proceso hijo
				break; 
			default: // Aqui estamos en el padre
				pidPadre = wait(NULL); //Esperamos a que termine el hijo
				exit(0);
		}
    }
    pidPadre = wait(NULL);
    exit(0);
}
