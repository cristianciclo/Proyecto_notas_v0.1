public class Grupo {
  private String nombre;
  private String nota;
  public Grupo(String n, String a) {
    nombre=n;
    nota=a;
  }
  
  public Grupo() { }
  public void setNombre(String n) {
     nombre=n;
  }
  public void setNota(String a) {
     nota=a;
  }
  public String getNota() {
     return nota;
  }
  public String getNombre() {
     return nombre;
  }
} 
