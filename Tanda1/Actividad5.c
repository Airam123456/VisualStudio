//Tanda 1, Actividad 5: Programa que genere una sucesion de n hijos y nietos
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
void main()
{
    pid_t pid;

    pid = fork(); // Se crea el primer hijo
    for (int i = 1; i < 8; i++)
    {    
        if(pid == -1)
        {
            printf("No se ha podido crear el proceso hijo");
            exit(0);
        }
        if (pid == 0)
        {
            printf( "Soy el hijo %d, Mi padre es %d y mi PID es %d \n" ,i,getppid(),getpid());
            pid = fork();
        }
        else
        {
            pid= wait(NULL);
        }
    }
    exit(0);
}



