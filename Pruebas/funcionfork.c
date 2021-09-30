#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
void main()
{
    __pid_t pid;
    pid = fork();
    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo");
        exit(-1);
    }
    if(pid == 0) // Este es el proceso hijo
    {
        printf("Soy el proceso hijo \n\t Mi PID es %d, El PID de mi padre es: %d.\n",getpid(),getppid());
    }
    else
    {
        printf("Soy el proceso padre \n\t Mi PID es %d, El PID de mi padre es: %d.\n\t Mi Hijo: %d termino. \n",getpid(),getppid(),pid);
    }
    exit(0);
}