package br.com.lgr.taksweb.model;

import br.com.lgr.taksweb.model.Status;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-16T10:11:01")
@StaticMetamodel(Tasks.class)
public class Tasks_ { 

    public static volatile SingularAttribute<Tasks, Status> idStatus;
    public static volatile SingularAttribute<Tasks, Date> dtCriacao;
    public static volatile SingularAttribute<Tasks, String> conclusao;
    public static volatile SingularAttribute<Tasks, String> titulo;
    public static volatile SingularAttribute<Tasks, Integer> id;
    public static volatile SingularAttribute<Tasks, Date> dtEdicao;
    public static volatile SingularAttribute<Tasks, String> descricao;
    public static volatile SingularAttribute<Tasks, Date> dtExclusao;

}