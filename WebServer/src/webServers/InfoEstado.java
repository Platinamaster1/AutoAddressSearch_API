package webServers;

public class InfoEstado
{
	/**
	 * The attribute that represents the State's Name of an Address.
	 */
    private String nome;
    /**
	 * This Method is used when the developer wants to know the State's Name value, but by this method, it can't be changed.
	 * @return The State's Name value, which in the class is Private
	 */
    public String getNome ()
    {
        return this.nome;
    }
    /**
	 * This method verify if the State's Name is valid and if so, gives the value from the param to the attribute
	 * @param nome Represents the State's Name attribute
	 * @throws Exception When the State's Name is invalid.
	 */
    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.length()==0)
            throw new Exception ("Nome ausente");

        this.nome = nome;
    }
    
    /**
	 * The attribute that represents the IBGE Code of the State of an Address.
	 */
    private String codigo_ibge;
    /**
	 * This Method is used when the developer wants to know the IBGE Code value, but by this method, it can't be changed.
	 * @return The IBGE Code's value, which in the class is Private
	 */
    public  String getCodigo_ibge ()
    {
        return this.codigo_ibge;
    }
    /**
	 * This method verify if the IBGE Code is valid and if so, gives the value from the param to the attribute
	 * @param codigoIBGE Represents the IBGE Code attribute
	 * @throws Exception When the IBGE Code is invalid.
	 */
    public void setCodigo_ibge (String codigoIBGE) throws Exception
    {
        if (codigoIBGE==null || codigoIBGE.length()==0)
            throw new Exception ("Codigo do IBGE ausente");

        this.codigo_ibge = codigoIBGE;
    }
    
    /**
	 * The attribute that represents the Area(km²) of the State of an Address.
	 */
    private String area_km2;
    /**
	 * This Method is used when the developer wants to know the Area(km²) value, but by this method, it can't be changed.
	 * @return The Area(km²)'s value, which in the class is Private
	 */
    public  String getArea_km2 ()
    {
        return this.area_km2;
    }
    /**
	 * This method verify if the Area(km²) is valid and if so, gives the value from the param to the attribute
	 * @param areaEmKm2 Represents the Area(km²) attribute
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
	 * @param nome Represents the State's Name attribute
	 * @param codigoIBGE Represents the IBGE Code attribute
	 * @param areaEmKm2 Represents the Area(km²) attribute
	 * 
	 * @throws Exception When any of the method used founds an error.
	 */
    public InfoEstado (String nome, String codigoIBGE, String areaEmKm2) throws Exception
    {
        this.setNome        (nome);
        this.setCodigo_ibge (codigoIBGE);
        this.setArea_km2    (areaEmKm2);
    }

    // exigencia do mapeador de JSon
    public InfoEstado () {}
    
    /**
	 * This method make a printable object containing all the attributes and its values. It is used to print all the informations about this InfoEstado to search for error mainly.
	 * @return ret, A String made in a formatted way that shows the values of the attributes.
	 */
    public String toString ()
    {
        return this.nome+
                " / Codigo IBGE: "+
                this.codigo_ibge+
                " / Area(km2): "+
                this.area_km2;
    }
    
    /**
	 * This Method is used to Compare two Objects and see if they are equal or not, it represents the Object way of doing "==" in JAVA.
	 * @return true, If they are equal.
	 * @return false, If they are not equal.
	 */
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        //if (!(this.getClass() != obj.getClass())
        //if (!(obj.getClass != InfoEstado.class))
        if (!(obj instanceof InfoEstado))
            return false;

        InfoEstado infoEstado = (InfoEstado)obj;

        if (!this.nome.equals(infoEstado.nome))
            return false;

        if (!this.codigo_ibge.equals(infoEstado.codigo_ibge))
            return false;

        if (!this.area_km2.equals(infoEstado.area_km2))
            return false;

        return true;
    }

    /**
	 * This method make a code that is unique for each different object existent, its the code that identifies the Object in a hashList.
	 * @return ret, A Integer that contains the hash code of the object.
	 */
    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.nome       .hashCode();
        ret = 2*ret + this.codigo_ibge.hashCode();
        ret = 2*ret + this.area_km2   .hashCode();

        return ret;
    }

    /**
	 * This method is the Constructor of Copies, It is like the constructor itself, but it's used to create an InfoEstado with the same values of the one that is in the param.
	 * @param model It's the InfoEstado that will have their data copied into the one that called this method.
	 * @throws Exception When the model given is null (wasn't initialized).
	 */
    public InfoEstado (InfoEstado modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.nome        = modelo.nome;
        this.codigo_ibge = modelo.codigo_ibge;
        this.area_km2    = modelo.area_km2;
    }

    /**
	 * This method works together with the Constructor of Copies to make a deep copy of an InfoEstado, It's a clone itself.
	 * @return The InfoEstado cloned as an Object's Instance.
	 */
    public Object clone ()
    {
        InfoEstado ret=null;

        try
        {
            ret = new InfoEstado (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}