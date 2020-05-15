package Implementacion;

public class Valoracion {
    private int nota;
    String comentario;
    String nombrePlato;

    public Valoracion(){

    }
    public Valoracion(int nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
    
    //Es necesario para poder hacer las pruebas (test/guardardatos/GuardarValoracion.java) 
  	@Override
  	public int hashCode() {
  		final int prime = 31;
  		int result = 1;
  		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
  		result = prime * result + ((nombrePlato == null) ? 0 : nombrePlato.hashCode());
  		result = prime * result + nota;
  		return result;
  	}
  	
  	@Override
  	public boolean equals(Object obj) {
  		if (this == obj)
  			return true;
  		if (obj == null)
  			return false;
  		if (getClass() != obj.getClass())
  			return false;
  		Valoracion other = (Valoracion) obj;
  		if (comentario == null) {
  			if (other.comentario != null)
  				return false;
  		} else if (!comentario.equals(other.comentario))
  			return false;
  		if (nombrePlato == null) {
  			if (other.nombrePlato != null)
  				return false;
  		} else if (!nombrePlato.equals(other.nombrePlato))
  			return false;
  		if (nota != other.nota)
  			return false;
  		return true;
  	}
}
