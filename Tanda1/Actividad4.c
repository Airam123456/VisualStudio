// Tanda 1, Actividad 4: Generar una estructura con un proceso padre y 3 hijos
#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
#include<sys/wait.h>
void main()
{
    pid_t pid,pid_hijo_1,pid_hijo_2,pid_hijo_3;

    //Creacion del primer hijo
    pid = fork();
    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo 1");
        exit(-1);
    }
    if(pid == 0) // Proceso hijo 1
    {
        printf("Soy el proceso hijo 1, Mi padre es %d y mi PID es %d \n" ,getppid(),getpid());
        exit(0);
    }

    //Creacion del segundo hijo
    pid = fork();
    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo 2");
        exit(-1);
    }
    if(pid == 0) // Proceso hijo 2
    {
        printf("Soy el proceso hijo 2, Mi padre es %d y mi PID es %d \n" ,getppid(),getpid());
        exit(0);
    }

    //Creacion del tercer hijo
    pid = fork();
    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo 3");
        exit(-1);
    }
    if(pid == 0) // Proceso hijo 3
    {
        printf("Soy el proceso hijo 3, Mi padre es %d y mi PID es %d \n" ,getppid(),getpid());
    }
    else 
    {
        pid_hijo_1 = wait(NULL);
        pid_hijo_2 = wait(NULL);
        pid_hijo_3 = wait(NULL);
        printf("Proceso padre %d\n",getpid()); //Muestra el proceso padre
    }
    exit(0);
}   