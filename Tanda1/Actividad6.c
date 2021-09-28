#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
void main()
{
    pid_t pid;
    //Creacion del primer hijo
    pid = fork();
    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo 1");
        exit(-1);
    }
    if(pid == 0) // Proceso hijo 1
    {
        printf("Soy hijo 1, Mi padre es PID = %d , yo soy PID =  %d \n" ,getppid(),getpid());
        exit(0);
    }
  
    pid = fork();
    //Creacion del segundo hijo
    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo 2");
        exit(-1);
    }
    if(pid == 0) // Proceso hijo 2
    {
        printf("Soy hijo 2, Mi padre es PID = %d , yo soy PID =  %d \n" ,getppid(),getpid());

        //Creacion del tercer hijo, el cual desciende del hijo 2
        pid = getppid;
        pid = fork();
        if(pid == -1)
        {
            printf("No se ha podido crear el proceso hijo 3");
            exit(-1);
        }
        if(pid == 0) // Proceso hijo 3
        {
            printf("Soy hijo 3, Mi padre es PID = %d , yo soy PID =  %d \n" ,getppid(),getpid());
            exit(0);
        }
    }
}