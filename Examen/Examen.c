#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main ()
{ 
  int status;
  pid_t hijo_pid;
 
  hijo_pid = fork ();
  if (hijo_pid == 0) {
      printf("Soy el proceso padre \n");
      sleep (2);
		exit (0);
   }
  else {
      exit (0);
  }
  return 0;
}