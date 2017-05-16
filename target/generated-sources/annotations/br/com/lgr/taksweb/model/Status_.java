package br.com.lgr.taksweb.model;

import br.com.lgr.taksweb.model.Tasks;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-16T10:11:01")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile CollectionAttribute<Status, Tasks> tasksCollection;
    public static volatile SingularAttribute<Status, Integer> id;
    public static volatile SingularAttribute<Status, String> descricao;

}