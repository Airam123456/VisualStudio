//atraparSenial: Bucle que va sacando por pantalla un mensaje cada segundo y usando un signal que capture
// una señal de input como el teclado y saque un mensaje
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>

int num = 1;
void manejador (int signal ) // las instrucciones para cuando captura la señal
{
	num =2;
    printf("Input capurado \n");
}
void main ()
{ 
    while (num == 1)
    {
        printf("Estoy enviando un mensaje \n"); //Hay que poner el \n para que salga el mensaje, si no no aparece
        sleep(1); // retraso de 1s
        signal(SIGINT, manejador); // aqui cuando capta un input de tipo SIGINT ejecuta el manejador
    } 
    exit(0);
}