package webServers;

/**
 * The InfoCidade Class consists of a class which presents the attributes, getters and setters of and Object that comes from a web API of Zip Codes. 
 * It is used to organize all the information that comes from a JSON object called InfoCidade.
 * @author André Luis dos Reis Gomes de Carvalho.
 */
public class InfoCidade
{
    private String codigo_ibge;
    /**
	 * This Method is used when the developer wants to know the IBGE Code value, but by this method, it can't be changed.
	 * @return The IBGE Code's value, which in the class is Private.
	 */
    public  String getCodigo_ibge ()
    {
        return this.codigo_ibge;
    }
    /**
	 * This method verify if the IBGE Code is valid and if so, gives the value from the param to the attribute.
	 * @param codigoIBGE Represents the IBGE Code attribute.
	 * @throws Exception When the IBGE Code is invalid.
	 */
    public void setCodigo_ibge (String codigoIBGE) throws Exception
    {
        if (codigoIBGE==null || codigoIBGE.length()==0)
            throw new Exception ("Codigo do IBGE ausente");

        this.codigo_ibge = codigoIBGE;
    }
    
    private String area_km2;
    /**
	 * This Method is used when the developer wants to know the Area(km²) value, but by this method, it can't be changed.
	 * @return The Area(km²)'s value, which in the class is Private.
	 */
    public  String getArea_km2()
    {
        return this.area_km2;
    }
    /**
	 * This method verify if the Area(km²) is valid and if so, gives the value from the param to the attribute.
	 * @param areaEmKm2 Represents the Area(km²) attribute.
	 * @throws Exception When the Area(km²) is invalid.
	 */
    public void setArea_km2 (String areaEmKm2) throws Exception
    {
        if (areaEmKm2==null || areaEmKm2.length()==0)
            throw new Exception ("Area ausente");

        this.area_km2 = areaEmKm2;
    }
    
    /**
	 * This method is the class constructor, it gives to the attributes a value specified in the params.
	 * @param codigoIBGE Represents the IBGE Code attribute.
	 * @param areaEmKm2 Represents the Area(km²) attribute.
	 * @throws Exception When any of the method used founds an error.
	 */
    public InfoCidade (String codigoIBGE, String areaEmKm2) throws Exception
    {
        this.setCodigo_ibge (codigoIBGE);
        this.setArea_km2    (areaEmKm2);
    }

    // exigencia do mapeador de JSon
    public InfoCidade () {}
    
    /**
	 * This method make a printable object containing all the attributes and its values. It is used to print all the informations about InfoCidade to search for error, mainly.
	 * @return ret, A String made in a formatted way that shows the values of the attributes.
	 */
    public String toString ()
    {
        return "Codigo IBGE: "+
                this.codigo_ibge+
                " / Area(km2): "+
                this.area_km2;
    }
    /**
	 * This Method is used to Compare two Objects and see if they are equal or not, it represents the Object way of doing "==" in JAVA.
	 * @return true, if they are equal, and false if they aren't.
	 */
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        //if (!(this.getClass() != obj.getClass())
        //if (!(obj.getClass != InfoCidade.class))
        if (!(obj instanceof InfoCidade))
            return false;

        InfoCidade infoCidade = (InfoCidade)obj;

        if (!this.codigo_ibge.equals(infoCidade.codigo_ibge))
            return false;

        if (!this.area_km2.equals(infoCidade.area_km2))
            return false;

        return true;
    }
    /**
	 * This method make a code that is unique for each different object existent, its the code that identifies the Object in a hashList.
	 * @return ret, An Integer that contains the hash code of the object.
	 */
    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.codigo_ibge.hashCode();
        ret = 2*ret + this.area_km2   .hashCode();

        return ret;
    }
    /**
	 * This method is the Constructor of Copies, It is like the constructor itself, but it's used to create an InfoCidade with the same values of the one that is in the param.
	 * @param modelo It's the InfoCidade that will have their data copied into the one that called this method.
	 * @throws Exception When the model given is null (wasn't initialized).
	 */
    public InfoCidade (InfoCidade modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.codigo_ibge = modelo.codigo_ibge;
        this.area_km2    = modelo.area_km2;
    }
    /**
	 * This method works together with the Constructor of Copies to make a deep copy of an InfoCidade, It's a clone itself.
	 * @return The infoCidade cloned as an Object's Instance.
	 */
    public Object clone ()
    {
        InfoCidade ret=null;

        try
        {
            ret = new InfoCidade (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}