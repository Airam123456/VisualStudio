#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
/*
CREAR LAS PIPES AL PRINCIPIO Y USAR SWITCH


*/
void main ()
{
    pid_t pid1, pid2;
    int fd1[2], fd2[2];
    char buffer[20];
	char saludoAbuelo[]="Saludo del abuelo..";
    char saludoPadre[]="Saludo del padre..";
    char saludoHijo[]="Saludo del hijo..";
    char saludoNieto[]="Saludo del nieto..";
    pipe(fd1); // Se crea el pipe o tubería
	pid1 = fork(); //Se crea el hijo

    if(pid1 == -1)
    {
        printf("No se ha podido crear el proceso hijo");
        exit(0);
    }

    if(pid1 == 0) //Porceso Hijo
    {
        pipe(fd2); // Se crea el pipe o tubería
        pid2 = fork; // Se crea el nieto
    }

    if(pid2 == 0) // Proceso nieto
    {
        close(fd2[1]);
        read(fd2[0], buffer, sizeof(buffer));
        printf("\t\tEl NIETO recibe mensaje del padre: %s\n", buffer);
        printf("\t\tEl NIETO envia un mensaje al HIJO...\n");
        close(fd2[0]);
        write(fd2[1], saludoNieto, sizeof(saludoNieto));
    }
    else
    {
        if(pid1 == 0) // Proceso hijo
        {
            close(fd1[1]);
            read(fd1[0], buffer, sizeof(buffer));
            printf("\tEl HIJO recibe mensaje del abuelo: %s\n", buffer);
            printf("\tEl HIJO envia un mensaje al NIETO...\n");
            close(fd2[0]);
            write(fd2[1], saludoPadre, sizeof(saludoPadre));
            wait(NULL);
            close(fd2[1]);
            read(fd2[0], buffer, sizeof(buffer));
            printf("\tEl HIJO recibe mensaje de su hijo: %s\n", buffer);
            printf("\tEl HIJO envia un mensaje al ABUELO...\n");
            close(fd1[0]);
            write(fd1[1], saludoHijo, sizeof(saludoHijo));
        }
        else //Proceso abuelo
        {
            printf("El ABUELO envia mensaje al HIJO...\n");
            close(fd1[0]);
            write(fd1[1], saludoAbuelo, sizeof(saludoAbuelo));
            wait(NULL);
            close(fd1[1]);
            read(fd1[0], buffer, sizeof(buffer));
            printf("\tEl ABUELO recibe mensaje del HIJO: %s\n", buffer);
        }
    }
    exit(0);
}

