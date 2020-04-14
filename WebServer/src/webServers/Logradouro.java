package webServers;

/**
 * The Logradouro Class consists of a class which presents the attributes, getters and setters of and Object that comes from a web API of Zip Codes. 
 * It is used to organize all the information that comes from a JSON object called Logradouro.
 * @author André Luis dos Reis Gomes de Carvalho.
 */
public class Logradouro
{
    private String logradouro;
    /**
	 * This Method is used when the developer wants to know the Logradouro value, but by this method, it can't be changed.
	 * @return The Logradouro's value, which in the class is Private.
	 */
    public  String getLogradouro ()
    {
        return this.logradouro;
    }
    /**
	 * This method verify if the Logradouro is valid and if so, gives the value from the param to the attribute.
	 * @param logradouro Represents the Logradouro attribute.
	 * @throws Exception When the Logradouro is invalid.
	 */
    public void setLogradouro (String logradouro) throws Exception
    {
        if (logradouro==null || logradouro.length()==0)
            throw new Exception ("Logradouro ausente");

        this.logradouro = logradouro;
    }
    
    private String complemento;
    /**
	 * This Method is used when the developer wants to know the Complement value, but by this method, it can't be changed.
	 * @return The Complement's value, which in the class is Private.
	 */
    public  String getComplemento ()
    {
        return this.complemento;
    }
    /**
	 * This method verify if the Complement is valid and if so, gives the value from the param to the attribute.
	 * @param complemento Represents the Complement attribute.
	 * @throws Exception When the Complement is invalid.
	 */
    public void setComplemento (String complemento) throws Exception
    {
    	if(complemento != null)
    		this.complemento = complemento;
    	else
    		this.complemento = null;
    }

    private String bairro;
    /**
	 * This Method is used when the developer wants to know the Neighboorhood value, but by this method, it can't be changed.
	 * @return The Neighboorhood's value, which in the class is Private.
	 */
    public  String getBairro ()
    {
        return this.bairro;
    }
    /**
	 * This method verify if the Neighboorhood is valid and if so, gives the value from the param to the attribute.
	 * @param bairro Represents the Neighboorhood attribute.
	 * @throws Exception When the Neighboorhood is invalid.
	 */
    public void setBairro (String bairro) throws Exception
    {
        if (bairro==null || bairro.length()==0)
            throw new Exception ("Bairro ausente");

        this.bairro = bairro;
    }

    private String cidade;
    /**
	 * This Method is used when the developer wants to know the City value, but by this method, it can't be changed.
	 * @return The City's value, which in the class is Private.
	 */
    public  String getCidade ()
    {
        return this.cidade;
    }
    /**
	 * This method verify if the City is valid and if so, gives the value from the param to the attribute.
	 * @param cidade Represents the City attribute.
	 * @throws Exception When the City is invalid.
	 */
    public void setCidade (String cidade) throws Exception
    {
        if (cidade==null || cidade.length()==0)
            throw new Exception ("Cidade ausente");

        this.cidade = cidade;
    }
    
    private InfoCidade cidade_info;
    /**
	 * This Method is used when the developer wants to know the City Information value, but by this method, it can't be changed.
	 * @return The City Information's value, which in the class is Private.
	 */
    public InfoCidade getCidade_info ()
    {
        return (InfoCidade)this.cidade_info.clone();
    }
    /**
	 * This method verify if the City Information is valid and if so, gives the value from the param to the attribute.
	 * @param infoCidade Represents the City Information attribute.
	 * @throws Exception When the City Information is invalid.
	 */
    public void setCidade_info (InfoCidade infoCidade) throws Exception
    {
        if (infoCidade==null)
            throw new Exception ("Informacao de cidade ausente");

        this.cidade_info = (InfoCidade)infoCidade.clone();
    }

    private String estado;
    /**
	 * This Method is used when the developer wants to know the State value, but by this method, it can't be changed.
	 * @return The State's value, which in the class is Private.
	 */
    public  String getEstado ()
    {
        return this.estado;
    }
    /**
	 * This method verify if the State is valid and if so, gives the value from the param to the attribute.
	 * @param estado Represents the State attribute.
	 * @throws Exception When the State is invalid.
	 */
    public void setEstado (String estado) throws Exception
    {
        if (estado==null || estado.length()==0)
            throw new Exception ("Estado ausente");

        this.estado = estado;
    }

    private InfoEstado estado_info;
    /**
	 * This Method is used when the developer wants to know the State Information value, but by this method, it can't be changed.
	 * @return The State Information's value, which in the class is Private.
	 */
    public  InfoEstado getEstado_info ()
    {
        return (InfoEstado)this.estado_info.clone();
    }
    /**
	 * This method verify if the State Information is valid and if so, gives the value from the param to the attribute.
	 * @param infoEstado Represents the State Information attribute.
	 * @throws Exception When the State Information is invalid.
	 */
    public void setEstado_info (InfoEstado infoEstado) throws Exception
    {
        if (infoEstado==null)
            throw new Exception ("Informacao de estado ausente");

        this.estado_info = (InfoEstado)infoEstado.clone();
    }

    private String cep;
    /**
	 * This Method is used when the developer wants to know the Zip Code value, but by this method, it can't be changed.
	 * @return The Zip Code's value, which in the class is Private.
	 */
    public  String getCep ()
    {
        return this.cep;
    }
    /**
	 * This method verify if the Zip Code is valid and if so, gives the value from the param to the attribute.
	 * @param cep Represents the Zip Code attribute.
	 * @throws Exception When the Zip Code is invalid.
	 */
    public void setCep (String cep) throws Exception
    {
        if (cep==null || cep.length()==0)
            throw new Exception ("Logradouro ausente");

        this.cep = cep;
    }
    
    /**
	 * This method is the class constructor, it gives to the attributes a value specified in the params.
	 * @param complemento Represents the complemento attribute.
	 * @param logradouro Represents the logradouro attribute.
	 * @param bairro Represents the bairro attribute.
	 * @param cidade Represents the cidade attribute.
	 * @param cidade_info Represents the cidade_info attribute.
	 * @param estado Represents the estado attribute.
	 * @param estado_info Represents the estado_info attribute.
	 * @param cep Represents the cep attribute.
	 * 
	 * @throws Exception When any of the method used founds an error.
	 */
    public Logradouro (String complemento,
                       String logradouro, String bairro,
                       String cidade, InfoCidade cidade_info,
                       String estado, InfoEstado estado_info,
                       String cep) throws Exception
    {
        this.setComplemento (complemento);
        this.setLogradouro  (logradouro);
        this.setBairro      (bairro);
        this.setCidade      (cidade);
        this.setCidade_info (cidade_info);
        this.setEstado      (estado);
        this.setEstado_info (estado_info);
        this.setCep         (cep);
    }

    // exigencia do mapeador de JSon
    public Logradouro () {}
    
    /**
	 * This method make a printable object containing all the attributes and its values. It is used to print all the informations about this Logradouro to search for error mainly.
	 * @return ret, A String made in a formatted way that shows the values of the attributes.
	 */
    public String toString ()
    {
        return "Logradouro: "+
                this.logradouro+
                "\nComplemento: "+
                this.complemento+
                "\nCidade.....: "+
                this.cidade+
                " / "+
                this.cidade_info+
                "\nEstado.....: "+
                this.estado+
                " / "+
                this.estado_info+
                "\nC.E.P......: "+
                this.cep;
    }

    /**
	 * This Method is used to Compare two Objects and see if they are equal or not, it represents the Object way of doing "==" in JAVA.
	 * @return true, if they are equal, and false, if they aren't.
	 */
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        //if (!(this.getClass() != obj.getClass())
        //if (!(obj.getClass != Logradouro.class))
        if (!(obj instanceof Logradouro))
            return false;

        Logradouro cep = (Logradouro)obj;

        if (!this.logradouro.equals(cep.logradouro))
            return false;

        if ((this.complemento==null && cep.complemento!=null) ||
                (this.complemento!=null && cep.complemento==null) ||
                !this.complemento.equals(cep.complemento))
            return false;

        if (!this.cidade.equals(cep.cidade))
            return false;

        if (!this.cidade_info.equals(cep.cidade_info))
            return false;

        if (!this.estado.equals(cep.estado))
            return false;

        if (!this.estado_info.equals(cep.estado_info))
            return false;

        if (!this.cep.equals(cep.cep))
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

        ret = 2*ret + this.logradouro .hashCode();

        if (this.complemento!=null)
            ret = 2*ret + this.complemento.hashCode();

        ret = 2*ret + this.cidade     .hashCode();
        ret = 2*ret + this.cidade_info.hashCode();
        ret = 2*ret + this.estado     .hashCode();
        ret = 2*ret + this.estado_info.hashCode();
        ret = 2*ret + this.cep        .hashCode();

        return ret;
    }

    /**
	 * This method is the Constructor of Copies, It is like the constructor itself, but it's used to create a logradouro with the same values of the one that is in the param.
	 * @param modelo It's the Logradouro that will have their data copied into the one that called this method.
	 * @throws Exception When the model given is null (wasn't initialized).
	 */
    public Logradouro (Logradouro modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.logradouro  = modelo.logradouro;
        this.bairro = modelo.bairro;
        this.complemento = modelo.complemento;
        this.cidade      = modelo.cidade;
        this.cidade_info = (InfoCidade)modelo.cidade_info.clone();
        this.estado      = modelo.estado;
        this.estado_info = (InfoEstado)modelo.estado_info.clone();
        this.cep         = modelo.cep;
    }

    /**
	 * This method works together with the Constructor of Copies to make a deep copy of an Logradouro, It's a clone itself.
	 * @return The logradouro cloned as an Object's Instance.
	 */
    public Object clone ()
    {
        Logradouro ret=null;

        try
        {
            ret = new Logradouro (this);
        }
        catch (Exception ignored)
        {}

        return ret;
    }
}