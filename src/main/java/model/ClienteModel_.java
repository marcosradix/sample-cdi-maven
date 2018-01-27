package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-26T23:21:38.456-0300")
@StaticMetamodel(ClienteModel.class)
public class ClienteModel_ {
	public static volatile SingularAttribute<ClienteModel, Long> id;
	public static volatile SingularAttribute<ClienteModel, String> nome;
	public static volatile SingularAttribute<ClienteModel, String> cpf;
	public static volatile SingularAttribute<ClienteModel, Long> idade;
}
