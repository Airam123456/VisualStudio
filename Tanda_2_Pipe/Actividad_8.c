#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main ()
{
    int fd1[2], fd2[2];
    char buffer[80];
	char saludoAbuelo[]="Saludo del abuelo..";
    char saludoPadre[]="Saludo del padre..";
    char saludoHijo[]="Saludo del hijo..";
    char saludoNieto[]="Saludo del nieto..";
	pid_t pid1, pid2;
    pipe(fd1); // Se crea el pipe o tubería
	pid1 = fork();
    if(pid1 == -1)
    {
        printf("No se ha podido crear el proceso hijo...\n");
		exit (-1);
		
    }
    else
    {
        if (pid1 == 0)
        {
            pipe(fd2);
        }
    }

    if(pid2 == 0)
    {
        close(fd2[1]); // Cierra el descriptor de escritura
        read (fd2[0], buffer, sizeof(buffer)); // leo el pipe
        printf ("\tEl NIETO recibe mensaje del padre: %s\n", buffer);
        printf ("\tEl NIETO envia un mensaje al hijo....\n");
        write (fd2[1], saludoPadre, sizeof(saludoPadre));  
    }
    else
    {
        
    }
    /*
        {
            close(fd1[0]); // Cierra el descriptor de lectura
		    write (fd1[1], saludoAbuelo, sizeof(saludoAbuelo));
		    printf ("El ABUELO envía un mensaje al HIJO....\n");

        } 




    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo...\n");
        exit (-1);
        
    }
    else
    {
        if (pid == 0)
        {
            
        }
        else
        {
            close(fd2[0]); // Cierra el descriptor de lectura
            write (fd2[1], saludoPadre, sizeof(saludoPadre));
            printf ("\tEl HIJO envía un mensaje al NIETO....\n");
            wait;
        }  
    }
    */
}

