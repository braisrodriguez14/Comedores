package sensores;

public class SensorImp implements Sensor {

	@Override
	public int leerIdBandeja() {
		return (int) ( Math.random() * 2147483647.0 );
	}

	@Override
	public int leerIdVale() {
		return (int) ( Math.random() * 2147483647.0 );
	}

}
