package es.android.xml.beans;

public class Noticia {

	private String titulo;
	private String link;
	private String descripcion;
	private String autor;
	private String fecha;
	private String guid;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String pudDate) {
		this.fecha = pudDate;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return "Noticia [titulo=" + titulo + ", link=" + link
				+ ", descripcion=" + descripcion + ", autor=" + autor
				+ ", pudDate=" + fecha + ", guid=" + guid + "]";
	}

}
