package br.com.fatecpp.hiper_soft.model.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Caixa.class)
public abstract class Caixa_ {

	public static volatile SingularAttribute<Caixa, Integer> usuCod;
	public static volatile SingularAttribute<Caixa, Date> cxFecha;
	public static volatile SingularAttribute<Caixa, Integer> codUsu;
	public static volatile SingularAttribute<Caixa, BigDecimal> cxSaldoIni;
	public static volatile SingularAttribute<Caixa, Integer> cxCod;
	public static volatile SingularAttribute<Caixa, Date> cxAber;
	public static volatile SingularAttribute<Caixa, BigDecimal> cxSaldoFim;

}

