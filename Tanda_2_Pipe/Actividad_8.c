#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main (){
    pid_t pid2, pid1;

    int fd1[2], fd2[2];
    char buffer [50];

    pipe(fd1);
    pipe(fd2);
    pid1 = fork();

    switch (pid1) {
        case -1:
            printf("No se ha podido crear el proceso HIJO\n");
            exit(-1);

        case 0:
            pid2 = fork();


            switch (pid2) {
                case -1:
                    printf("No se ha podido crear el proceso NIETO\n");
                    exit(-1);
                case 0:  //NIETO
                  
                    //Recibe mensaje del hijo
					close(fd2[1]);
					read(fd2[0], buffer, sizeof(buffer));
					printf("\t\tEl NIETO recibe mensaje del padre: %s\n", buffer);
					
					//Envia mensaje al hijo
					close(fd1[0]);
					char saludoNieto[] = "Saludo del nieto";
					write(fd1[1], saludoNieto, sizeof(saludoNieto));
					printf("\t\tEl NIETO envía un mensaje al HIJO\n");

					exit(0);

                default: //HIJO
                   
                    //Recibe mensaje del padre
					close(fd1[1]);
					read(fd1[0], buffer, sizeof(buffer));
					printf("\tEl HIJO recibe mensaje del ABUELO: %s\n", buffer);
					
					//Envia mensaje al nieto
					char saludoHijo[] = "Saludo del padre";
					write(fd2[1], saludoHijo, sizeof(saludoHijo));
					printf("\tEl HIJO envía un mensaje al NIETO......\n");

					wait(NULL);

					//Recibe mensaje del nieto
					close(fd1[1]);
					read(fd1[0], buffer, sizeof(buffer));
					printf("\tEL HIJO recibe mensaje de su hijo: %s\n", buffer);
					
					//Envia mensaje al abuelo
					char saludoHijo2[] = "Saludo del hijo";
					close(fd2[0]);
					write(fd2[1], saludoHijo2, sizeof(saludoHijo2));
					printf("\tEl HIJO envia un mensaje al ABUELO......\n");
						
					exit(0);

                    
            }
            break;
        default: //ABUELO
           
            //Enviar mensaje al hijo
			close(fd1[0]);
			char saludoAbuelo[] = "Saludo del abuelo..";
			write(fd1[1], saludoAbuelo, sizeof(saludoAbuelo));	
			printf("El ABUELO envía un mensaje al HIJO.......\n");
			
			wait(NULL);

			//Recibir mensaje del hijo
			close(fd2[1]);
			read(fd2[0], buffer, sizeof(buffer));
			printf("El ABUELO recibe mensaje del HIJO: %s\n", buffer);


    }
    
    exit (0);


}


    /*
    if(pid1 == -1)
    {
        printf("No se ha podido crear el proceso hijo");
        exit(0);
    }

    if(pid1 == 0) //Porceso Hijo
    {
       
        

        if(pid2 == 0) // Proceso hijo
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
            close(fd2[1]);
            read(fd2[0], buffer, sizeof(buffer));
            printf("\t\tEl NIETO recibe mensaje del padre: %s\n", buffer);
            printf("\t\tEl NIETO envia un mensaje al HIJO...\n");
            close(fd2[0]);
            write(fd2[1], saludoNieto, sizeof(saludoNieto));
        }
    }

    if(pid2 == 0) // Proceso nieto
    {
        
    }
    else
    {
        printf("El ABUELO envia mensaje al HIJO...\n");
            close(fd1[0]);
            write(fd1[1], saludoAbuelo, sizeof(saludoAbuelo));
            wait(NULL);
            close(fd1[1]);
            read(fd1[0], buffer, sizeof(buffer));
            printf("\tEl ABUELO recibe mensaje del HIJO: %s\n", buffer);
    }
    exit(0);

    */


