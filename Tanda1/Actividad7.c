#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
void main()
{
    __pid_t pid;
    int variable = 6;
    printf("Valor inicial de la variable:  %d \n",variable);
    pid = fork(); //Creamos un proceso hijo
    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo");
        exit(-1);
    }
    if(pid == 0) // Proceso hijo 
    {
        printf("Variable en Proceso Hijo:  %d \n", (variable-5)); // Si estamos en el hijo restamos 5
        exit(0);
    }
    else //Proceso padre
    {
        printf("Variable en Proceso Padre:  %d \n", (variable+5)); // Si estamos en el padre sumamos 5
        exit(0);
    }
}