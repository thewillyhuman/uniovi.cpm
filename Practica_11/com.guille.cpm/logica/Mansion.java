package logica;

public class Mansion {
	  private String codigo;
	  private String zona;
	  private String localidad;
	  private String descripcion;
	  private float precio;

	  public Mansion (String codigo, String zona, String localidad, String descripcion,
	                  float precio) {
	    this.codigo = codigo;
	    this.zona = zona;	
	    this.localidad = localidad;
	    this.descripcion = descripcion;
	    this.precio = precio;
	  }

	  public String getCodigo() {
	    return codigo;
	  }

	  public void setCodigo(String codigo) {
	    this.codigo = codigo;
	  }

	  public String getZona() {
			return zona;
		}

	  public void setZona(String zona) {
			this.zona = zona;
		}
	  
	  public String getLocalidad() {
	    return localidad;
	  }

	  public void setLocalidad (String localidad) {
	    this. localidad = localidad;
	  }

	  public String getDescripcion() {
	    return descripcion;
	  }

	  public void setDescripcion(String descripcion) {
	    this.descripcion = descripcion;
	  }

	  public float getPrecio() {
	    return precio;
	  }

	  public void setPrecio(float precio) {
	    this.precio = precio;
	  }

	 
	}

