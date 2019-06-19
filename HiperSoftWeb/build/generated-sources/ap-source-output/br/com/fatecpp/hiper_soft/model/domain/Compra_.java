package br.com.fatecpp.hiper_soft.model.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Compra.class)
public abstract class Compra_ {

	public static volatile SingularAttribute<Compra, Integer> fornecedorCodFor;
	public static volatile SingularAttribute<Compra, Date> dataCom;
	public static volatile SingularAttribute<Compra, Integer> codCom;
	public static volatile SingularAttribute<Compra, BigDecimal> totalCom;
	public static volatile SingularAttribute<Compra, Integer> parcCom;
	public static volatile SingularAttribute<Compra, String> tpPag;
	public static volatile SingularAttribute<Compra, Integer> numNota;

}

