package br.com.fatecpp.hiper_soft.model.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Venda.class)
public abstract class Venda_ {

	public static volatile SingularAttribute<Venda, Date> dataVen;
	public static volatile SingularAttribute<Venda, Integer> codCli;
	public static volatile SingularAttribute<Venda, Integer> caixaCxCod;
	public static volatile SingularAttribute<Venda, Integer> cxCod;
	public static volatile SingularAttribute<Venda, BigDecimal> venTotal;
	public static volatile SingularAttribute<Venda, Integer> vendaCod;

}

