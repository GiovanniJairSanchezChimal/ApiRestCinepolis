package com.mx.ApiRestCinepolis.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name= "Peliculas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Peliculas {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)//SI EL PK ES AUTOINCREMENTABLE
	@Column(name="ID_PELI", columnDefinition = "INT", nullable = false)
	private Integer id;
	
	@Column(name = "NOMBRE", columnDefinition="VARCHAR2(90)", nullable=false)
	private String nombre;
	
	@Column(name="PRECIO", columnDefinition ="FLOAT", nullable=false)
	private String precio;
	
	@Column(name="FECHA_LANZ", columnDefinition="DATE", nullable=false)
	private Date fechaLanz;
	
	@Column(name="STOCK", columnDefinition="INT", nullable=false)
	private Integer stock;
}
