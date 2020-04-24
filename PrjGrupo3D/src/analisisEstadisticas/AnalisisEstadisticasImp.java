
package analisisEstadisticas;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import modelo.Estadistica;
import modelo.Plato;

public class AnalisisEstadisticasImp implements AnalisisEstadisticas {

	private GestionDatos gestionDatos;

	public AnalisisEstadisticasImp( ) {
		gestionDatos = null;
	}

	@Override
	public void setGestionDatos( GestionDatos gestionDatos ) {
		this.gestionDatos = gestionDatos;

	}

	@Override
	public synchronized int ocupacionActual( ) {
		if( gestionDatos != null ) {
			ArrayList< Estadistica > estadisticas = gestionDatos.getEstadisticas( );
			int ocupacion = 0;
			for( Estadistica estadistica : estadisticas ) {
				if( estadistica.getHoraDevolucion( ).equals( "-1" ) ) {
					ocupacion += 1;
				}
			}
			return ocupacion;
		}
		else {
			return -1;
		}
	}

	@Override
	public synchronized Plato platoMasSelecionado( ) {
		if( gestionDatos != null ) {
			Plato plato = null;

			ArrayList< Plato > platos = gestionDatos.getPlatos( );
			ArrayList< Estadistica > estadisticas = gestionDatos.getEstadisticas( );

			int[ ] cantidades = new int[ platos.size( ) ];
			int cantidadMaxima = -1;

			plato = platos.get( 0 );
			for( int i = 0; i < platos.size( ); i++ ) {
				cantidades[ i ] = 0;
				for( Estadistica estadistica : estadisticas ) {
					if( estadistica.getBandeja( ).getPrimero( ).getNombre( ).equals( platos.get( i ).getNombre( ) )
							|| estadistica.getBandeja( ).getSegundo( ).getNombre( )
									.equals( platos.get( i ).getNombre( ) ) ) {
						cantidades[ i ] += 1;
					}
				}
				if( cantidades[ i ] > cantidadMaxima ) {
					cantidadMaxima = cantidades[ i ];
					plato = platos.get( i );
				}
			}

			return plato;
		}
		else {
			return null;
		}
	}

	@Override
	public synchronized Plato platoMenosSelecionado( ) {
		if( gestionDatos != null ) {
			Plato plato = null;

			ArrayList< Plato > platos = gestionDatos.getPlatos( );
			ArrayList< Estadistica > estadisticas = gestionDatos.getEstadisticas( );

			int[ ] cantidades = new int[ platos.size( ) ];
			int cantidadMinima = Integer.MAX_VALUE;

			plato = platos.get( 0 );
			for( int i = 0; i < platos.size( ); i++ ) {
				cantidades[ i ] = 0;
				for( Estadistica estadistica : estadisticas ) {
					if( estadistica.getBandeja( ).getPrimero( ).getNombre( ).equals( platos.get( i ).getNombre( ) )
							|| estadistica.getBandeja( ).getSegundo( ).getNombre( )
									.equals( platos.get( i ).getNombre( ) ) ) {
						cantidades[ i ] += 1;
					}
				}
				if( cantidades[ i ] < cantidadMinima ) {
					cantidadMinima = cantidades[ i ];
					plato = platos.get( i );
				}
			}

			return plato;
		}
		else {
			return null;
		}
	}

	@Override
	public synchronized Plato platoMejorValorado( ) {
		if( gestionDatos != null ) {
			Plato plato = null;

			ArrayList< Plato > platos = gestionDatos.getPlatos( );
			ArrayList< Estadistica > estadisticas = gestionDatos.getEstadisticas( );

			double[ ] valoraciones = new double[ platos.size( ) ];
			int[ ] cantidades = new int[ platos.size( ) ];
			double valoracionMaxima = -1.0;

			plato = platos.get( 0 );
			for( int i = 0; i < platos.size( ); i++ ) {
				valoraciones[ i ] = 0;
				cantidades[ i ] = 0;
				for( Estadistica estadistica : estadisticas ) {
					if( platos.get( i ).getTipo( ).equals( "PRIMERO" )
							&& estadistica.getBandeja( ).getPrimero( ).getNombre( )
									.equals( platos.get( i ).getNombre( ) ) ) {
						valoraciones[ i ] += (double) estadistica.getValoracionPrimero( );
						cantidades[ i ] += 1;
					}
					else if( platos.get( i ).getTipo( ).equals( "SEGUNDO" )
							&& estadistica.getBandeja( ).getSegundo( ).getNombre( )
									.equals( platos.get( i ).getNombre( ) ) ) {
						valoraciones[ i ] += (double) estadistica.getValoracionSegundo( );
						cantidades[ i ] += 1;
					}
				}

				if( ( cantidades[ i ] != 0 ) && ( valoraciones[ i ] / cantidades[ i ] > valoracionMaxima ) ) {
					valoracionMaxima = valoraciones[ i ] / cantidades[ i ];
					plato = platos.get( i );
				}
			}

			return plato;
		}
		else {
			return null;
		}
	}

	@Override
	public synchronized Plato platoPeorValorado( ) {
		if( gestionDatos != null ) {
			Plato plato = null;

			ArrayList< Plato > platos = gestionDatos.getPlatos( );
			ArrayList< Estadistica > estadisticas = gestionDatos.getEstadisticas( );

			double[ ] valoraciones = new double[ platos.size( ) ];
			int[ ] cantidades = new int[ platos.size( ) ];
			double valoracionMinima = 5.1;

			plato = platos.get( 0 );
			for( int i = 0; i < platos.size( ); i++ ) {
				valoraciones[ i ] = 0;
				cantidades[ i ] = 0;
				for( Estadistica estadistica : estadisticas ) {
					if( platos.get( i ).getTipo( ).equals( "PRIMERO" )
							&& estadistica.getBandeja( ).getPrimero( ).getNombre( )
									.equals( platos.get( i ).getNombre( ) ) ) {
						valoraciones[ i ] += (double) estadistica.getValoracionPrimero( );
						cantidades[ i ] += 1;
					}
					else if( platos.get( i ).getTipo( ).equals( "SEGUNDO" )
							&& estadistica.getBandeja( ).getSegundo( ).getNombre( )
									.equals( platos.get( i ).getNombre( ) ) ) {
						valoraciones[ i ] += (double) estadistica.getValoracionSegundo( );
						cantidades[ i ] += 1;
					}
				}

				if( ( cantidades[ i ] != 0 ) && ( valoraciones[ i ] / cantidades[ i ] < valoracionMinima ) ) {
					valoracionMinima = valoraciones[ i ] / cantidades[ i ];
					plato = platos.get( i );
				}
			}

			return plato;
		}
		else {
			return null;
		}
	}

	@Override
	public synchronized float ocupacionDiaSemana( int dia ) {
		if( gestionDatos != null ) {
			return 0.78f;
		}
		else {
			return -1.0f;
		}
	}

	@Override
	public synchronized int horaMasFrecuente( ) {
		if( gestionDatos != null ) {
			int horaMasFrecuente = 0;

			ArrayList< Estadistica > estadisticas = gestionDatos.getEstadisticas( );

			int[ ] horas = new int[ 24 ];
			for( Estadistica estadistica : estadisticas ) {
				horas[ Integer.parseInt( estadistica.getHoraAsignacion( ).split( ":" )[ 0 ].trim( ) ) ] += 1;
			}
			int maximoVecesHora = -1;
			for( int i = 0; i < 24; i++ ) {
				if( horas[ i ] > maximoVecesHora ) {
					horaMasFrecuente = i;
					maximoVecesHora = horas[ i ];
				}
			}

			return horaMasFrecuente;
		}
		else {
			return -1;
		}
	}

	@Override
	public synchronized float duracionMediaComida( ) {
		if( gestionDatos != null ) {

			ArrayList< Estadistica > estadisticas = gestionDatos.getEstadisticas( );

			int comidas = 0;
			int minutos = 0;
			int horasAsignacion;
			int minutosAsignacion;
			int horasDevolucion;
			int minutosDevolucion;

			for( Estadistica estadistica : estadisticas ) {
				if( !estadistica.getHoraDevolucion( ).equals( "-1" ) ) {
					horasAsignacion = Integer.valueOf( estadistica.getHoraAsignacion( ).split( ":" )[ 0 ] );
					minutosAsignacion = Integer.valueOf( estadistica.getHoraAsignacion( ).split( ":" )[ 1 ] );
					horasDevolucion = Integer.valueOf( estadistica.getHoraDevolucion( ).split( ":" )[ 0 ] );
					minutosDevolucion = Integer.valueOf( estadistica.getHoraDevolucion( ).split( ":" )[ 1 ] );
					minutos += ( horasDevolucion * 60 + minutosDevolucion )
							- ( horasAsignacion * 60 + minutosAsignacion );
					comidas += 1;
				}
			}

			return ( (float) minutos ) / comidas;
		}
		else {
			return -1.0f;
		}
	}

	@Override
	public synchronized ArrayList< Plato > rankingPlatos( ) {
		if( gestionDatos != null ) {
			ArrayList< Plato > ranking = gestionDatos.getPlatos( );

			ArrayList< Plato > platos = gestionDatos.getPlatos( );
			Plato plato;

			for( int i = 0; i < 5; i++ ) {
				plato = platoMejorValoradoPrivate( platos );
				platos.remove( plato );
				ranking.add( plato );
			}

			return ranking;
		}
		else {
			return null;
		}
	}

	private Plato platoMejorValoradoPrivate( ArrayList< Plato > platos ) {
		Plato plato = null;
		
		if( platos != null ) {
			ArrayList< Estadistica > estadisticas = gestionDatos.getEstadisticas( );

			double[ ] valoraciones = new double[ platos.size( ) ];
			int[ ] cantidades = new int[ platos.size( ) ];
			double valoracionMaxima = -1.0;

			plato = platos.get( 0 );
			for( int i = 0; i < platos.size( ); i++ ) {
				valoraciones[ i ] = 0;
				cantidades[ i ] = 0;
				for( Estadistica estadistica : estadisticas ) {
					if( platos.get( i ).getTipo( ).equals( "PRIMERO" )
							&& estadistica.getBandeja( ).getPrimero( ).getNombre( )
									.equals( platos.get( i ).getNombre( ) ) ) {
						valoraciones[ i ] += (double) estadistica.getValoracionPrimero( );
						cantidades[ i ] += 1;
					}
					else if( platos.get( i ).getTipo( ).equals( "SEGUNDO" )
							&& estadistica.getBandeja( ).getSegundo( ).getNombre( )
									.equals( platos.get( i ).getNombre( ) ) ) {
						valoraciones[ i ] += (double) estadistica.getValoracionSegundo( );
						cantidades[ i ] += 1;
					}
				}

				if( ( cantidades[ i ] != 0 ) && ( valoraciones[ i ] / cantidades[ i ] > valoracionMaxima ) ) {
					valoracionMaxima = valoraciones[ i ] / cantidades[ i ];
					plato = platos.get( i );
				}
			}
		}

		return plato;
	}

}
