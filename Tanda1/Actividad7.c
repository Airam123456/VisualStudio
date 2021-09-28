#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
void main()
{
    __pid_t pid;
    int variable = 6;
    printf("Valor inicial de la variable:  %d \n",variable);
    pid = fork();
    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo");
        exit(-1);
    }
    if(pid == 0) // Proceso hijo 
    {
        printf("Variable en Proceso Hijo:  %d \n", (variable-5));
    }
    else //Proceso padre
    {
        printf("Variable en Proceso Padre:  %d \n", (variable+5));
    }
}