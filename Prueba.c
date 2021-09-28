// lecturaescritura.c
#include <fcntl.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>  // funcion strlen
#include <unistd.h>

int main(){
  int fd, fd2, numbytes;
  char buffer[10];
  char saludo[]="Un saludo!!!";

//// Escritura
  fd=open ("texto.txt",1); //// fichero se abre solo para escritura
  if (fd == -1)
     {
                printf("Error al abrir el fichero...\n");
                exit (-1);
     }
   printf("Escribo el saludo .... \n");
   write(fd, saludo, strlen(saludo));
   close(fd);

//// Lectura
  printf("Contenido del Fichero \n");
  fd2 = open("texto.txt", 0); //// fichero se abre solo para lectura
  while ((numbytes = read(fd2, &buffer, sizeof(char))) > 0){
        printf("%s",buffer);
  }
  close(fd2);
}