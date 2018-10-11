package edu.stanford.bmir.protege.examples.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.protege.editor.owl.model.OWLModelManager;
import org.protege.editor.owl.model.event.EventType;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.protege.editor.owl.ui.metrics.DLNamePanel;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.ClassExpressionType;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomVisitorEx;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLClassExpressionVisitorEx;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDataVisitorEx;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLIndividualVisitorEx;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;
import org.semanticweb.owlapi.model.OWLPropertyExpressionVisitorEx;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.stanford.bmir.protege.examples.*;
import edu.stanford.bmir.protege.examples.tab.ExampleWorkspaceTab;

public class Metrics extends JPanel {
	
	private static final Logger log = LoggerFactory.getLogger(Metrics.class);

    private JButton refreshButton = new JButton("Refresh");

    private JPanel panel = new JPanel();
    private OWLModelManager modelManager;

    private ActionListener refreshAction = e -> recalculate();
    private OWLModelManagerListener modelListener = event -> {
        if (event.getType() == EventType.ACTIVE_ONTOLOGY_CHANGED) {
            recalculate();
        }
    };
    
	protected AxiomVisitor avisitor = new AxiomVisitor();  
    protected ClassVisitor cvisitor = new ClassVisitor();
    protected DataVisitor dvisitor = new DataVisitor();
    protected IndividualVisitor ivisitor = new IndividualVisitor();
    protected RoleVisitor pvisitor = new RoleVisitor();
    
    //Klassenunterscheidung
    HashMap<String, Integer> class_distinc = new HashMap<String, Integer>();
    int it_class = 1;
    //Individuenunterscheidung
    HashMap<String, Integer> indiv_distinc = new HashMap<String, Integer>();
    int it_indiv = 1;
    //Propertyunterscheidung
    HashMap<String, Integer> prop_distinc = new HashMap<String, Integer>();
    int it_prop = 1;
    //wenn etwas nicht implementiertes vorkommt wird es nicht hinzugefügt
    boolean add_axiom = true;
    
    private OWLOntologyChangeListener changeListener;
    
    public Metrics(OWLModelManager modelManager) {
    	
    	log.info("Metrics initialzed");
    	
    	this.modelManager = modelManager;
    	    
    	changeListener = change -> {
    	    	log.info(change.toString());
    	    	recalculate();
    	    };
    	        	
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	recalculate(); 
        JScrollPane rollPane = new JScrollPane(panel);
        rollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        rollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        rollPane.setBounds(5, 5, 450, 450);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(550, 600));
        contentPane.add(rollPane);   
        modelManager.addOntologyChangeListener(changeListener);
        modelManager.addListener(modelListener);
        refreshButton.addActionListener(refreshAction);
        
    	add(contentPane);
    	add(refreshButton);
    }
    
    public void dispose() {
        modelManager.removeOntologyChangeListener(changeListener);
        modelManager.removeListener(modelListener);
        refreshButton.removeActionListener(refreshAction);
        log.info("Metrics disposed");
    }
    
    private void recalculate() {
    	log.info("Recalculate");
    	panel.removeAll();
    	//HashSet for avoiding duplicates
    	HashMap<String, HashSet> axiomtype_pattern = new HashMap<String, HashSet>();
        HashMap<String, Integer> axiomtype_count = new HashMap<String, Integer>();
        int numberAxiomsChecked = 0;
        
    	addaxiomtopanel("Total Axioms: " + modelManager.getActiveOntology().getAxiomCount(),true);
        for (OWLAxiom ax : modelManager.getActiveOntology().getAxioms()) {
        	String axiom = ax.accept(avisitor);
        	String ax_name = ax.getAxiomType().getName();
        	if (axiom != "") {
        		numberAxiomsChecked ++;
	        	if(axiomtype_pattern.containsKey(ax_name)) {
	        		HashSet pattern = axiomtype_pattern.get(ax_name);
	        		pattern.add(axiom);
	        		axiomtype_pattern.replace(ax_name, pattern);
	        		axiomtype_count.replace(ax_name, axiomtype_count.get(ax_name).intValue() + 1);
	        	}else {
	        		HashSet pattern = new HashSet();
	        		pattern.add(axiom);
	        		axiomtype_pattern.put(ax_name, pattern);
	        		axiomtype_count.put(ax_name, 1);
	        	}
        	}
        }
        
        addaxiomtopanel("Number of Axioms checked: " + numberAxiomsChecked , true);
        
        MapComparator comp = new MapComparator(axiomtype_count);
        TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>(comp);
        treeMap.putAll(axiomtype_count);
        
        for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
        		addaxiomtopanel("Number of " + entry.getKey() + " Axioms: " + entry.getValue(),true);
	           Iterator<String> i = axiomtype_pattern.get(entry.getKey()).iterator();
	           while (i.hasNext())
	        	   addaxiomtopanel(i.next(),false); 
        }           
    }
    
    private void addaxiomtopanel(String ax, boolean bold) {
    	JLabel textComponent = new JLabel();
    	Font font;
    	if (bold) {
    		font = new Font("Courier", Font.BOLD ,14);
    	} else {
    		font = new Font("Courier", Font.PLAIN ,14);
    	}
		textComponent.setFont(font);
    	textComponent.setText(ax);
    	textComponent.setAlignmentX(Component.LEFT_ALIGNMENT);
    	panel.add(textComponent);
    }
    
    private String convert_sub(OWLSubClassOfAxiom o) {
    	String result = o.getSubClass().accept(cvisitor) + " ⊑ " + o.getSuperClass().accept(cvisitor);
    	return checkaxiom(result);  	
   }
    private String convert_sop(OWLSubObjectPropertyOfAxiom sop) {
    	String result = sop.getSubProperty().accept(pvisitor) + " ⊑ " + sop.getSuperProperty().accept(pvisitor);
      	return checkaxiom(result);  	 
   }
       
   private String convert_opa(OWLObjectPropertyAssertionAxiom opa) {
       	String result = opa.getProperty().accept(pvisitor) + "(" + opa.getSubject().accept(ivisitor) + "," + opa.getObject().accept(ivisitor) + ")";
        return checkaxiom(result);
   }
       
   private String convert_dpa(OWLDataPropertyAssertionAxiom dpa) {
       	String result = dpa.getProperty().accept(pvisitor) + "(" + dpa.getSubject().accept(ivisitor) + "," + dpa.getObject().accept(dvisitor) + ")";
        return checkaxiom(result);
   }
       
   private String convert_ca(OWLClassAssertionAxiom ca) {
       	String result = ca.getClassExpression().accept(cvisitor) + "(" + ca.getIndividual().accept(ivisitor) + ")";
        return checkaxiom(result);
   }
       
   private String convert_opd(OWLObjectPropertyDomainAxiom opd) {
       	String result = "⊤ ⊑ ∀" +  opd.getProperty().accept(pvisitor) + "." + opd.getDomain().accept(cvisitor);
        return checkaxiom(result);
   }
       
   private String convert_fop(OWLFunctionalObjectPropertyAxiom fop) {
       	String result = "functional("+ fop.getProperty().accept(pvisitor) + ")";
        return checkaxiom(result);
   }
       
   private String convert_top(OWLTransitiveObjectPropertyAxiom top) {
       	String result = "transitive("+ top.getProperty().accept(pvisitor) + ")";
        return checkaxiom(result);
   }
       
   private String convert_opr(OWLObjectPropertyRangeAxiom opr) {
       	String result = "∃"+ opr.getProperty().accept(pvisitor) +".⊤ ⊑ " + opr.getRange().accept(cvisitor);
           return checkaxiom(result);
       }
        
   private String convert_equ(OWLEquivalentClassesAxiom ec) {
       	String result = "";
           boolean first = true;
           for ( OWLClassExpression cexp: ec.getClassExpressions()) {
                 if (first) {
                     result = cexp.accept(cvisitor);
                     first = false;
                 } else {
                     result = result + " ≡ " + cexp.accept(cvisitor);
                 }
             }
           return checkaxiom(result);
       }
       
   private String convert_djc(OWLDisjointClassesAxiom djc) {
	   String result = "";
       boolean first = true;
       for ( OWLClassExpression cexp: djc.getClassExpressions()) {
       	 if (first) {
                result = cexp.accept(cvisitor);
                first = false;
            } else {
                result = result + " ⊓ " + cexp.accept(cvisitor);
            }
         }
        result = result + " ⊑ ⊥"; 
        return checkaxiom(result);  	 
      }
       
       
   private String convert_sin(OWLSameIndividualAxiom sin) {
    	  String result = "";
          boolean first = true;
          for ( OWLIndividual cexp: sin.getIndividuals()) {
          	 if (first) {
                   result = cexp.accept(ivisitor);
                   first = false;
               } else {
                   result = result + " ≈ " + cexp.accept(ivisitor);
               }
            } 
         	 return checkaxiom(result);
       }
       
   private String convert_din(OWLDifferentIndividualsAxiom din) {
           String result = "";
           boolean first = true;
           for ( OWLIndividual cexp: din.getIndividuals()) {
          	 if (first) {
                   result = cexp.accept(ivisitor);
                   first = false;
               } else {
                   result = result + " ≈- " + cexp.accept(ivisitor);
               }
            } 
         	 return checkaxiom(result);
       }
       
   private String convert_eop(OWLEquivalentObjectPropertiesAxiom eop) {
           String result = "";
           boolean first = true;
           for ( OWLObjectPropertyExpression cexp: eop.getProperties()) {
          	 if (first) {
                   result = cexp.accept(pvisitor);
                   first = false;
               } else {
                   result = result + " ≡ " + cexp.accept(pvisitor);
               }
            } 
         	 return checkaxiom(result);
       }

    private String checkaxiom(String res_method) {
    	class_distinc.clear();
    	prop_distinc.clear();
    	indiv_distinc.clear();
    	
     	 it_class = 1;
     	 it_prop = 1;
     	 it_indiv = 1;
     	 
     	 if (add_axiom) {
     		 return res_method;
     	 } else {
     		 add_axiom = true;
     		 return "";	 
     	 }
    }
    
    
    private class ClassVisitor implements OWLClassExpressionVisitorEx<String>{

		@Override
		public String visit(OWLClass ce) {
			if(ce.isOWLThing()) return "⊤";
			if(ce.isOWLNothing()) return "⊥";
			int ident;
			if (class_distinc.containsKey(ce.getIRI().getFragment())) {
				ident = (int) class_distinc.get(ce.getIRI().getFragment());
			}else {
				class_distinc.put(ce.getIRI().getFragment(), it_class);
				ident = it_class;
				it_class ++;
			}
			return "class_" + ident;
		}

		@Override
		public String visit(OWLObjectIntersectionOf ce) {
			// TODO Auto-generated method stub
			String result = "";
	          boolean first = true;
	          boolean onlyclass = true;
	          int numberOperands = 0;
	          for (OWLClassExpression conjunct : ce.getOperands()) {
	                if (first) {
	                    result = conjunct.accept(this);
	                    first = false;
	                } else 
	                    result = result + " ⊓ " + conjunct.accept(this);
	                
	                if(conjunct.getClassExpressionType() != ClassExpressionType.OWL_CLASS) {
	                	onlyclass = false;
	                }
	                numberOperands++;
	            }
	          if(onlyclass && numberOperands > 2) {
	        	   return "(class ⊓ ... ⊓ class)";
	           }
	           return "(" + result + ")";
		}

		@Override
		public String visit(OWLObjectUnionOf ce) {
			// TODO Auto-generated method stub
			String result = "";
	          boolean first = true;
	          boolean onlyclass = true;
	          int numberOperands = 0;
	          for (OWLClassExpression conjunct : ce.getOperands()) {
	                if (first) {
	                    result = conjunct.accept(this);
	                    first = false;
	                } else {
	                    result = result + " ⊔ " + conjunct.accept(this);
	                }
	                if(conjunct.getClassExpressionType() != ClassExpressionType.OWL_CLASS) {
	                	onlyclass = false;
	                }
	                numberOperands++;
	            }

	          if(onlyclass && numberOperands > 2) {
	        	   return "(class ⊔ ... ⊔ class)";
	          }
	           return "(" + result + ")";
		}

		@Override
		public String visit(OWLObjectComplementOf ce) {
			return "¬(" + ce.getOperand().accept(this) + ")";
		}

		@Override
		public String visit(OWLObjectSomeValuesFrom ce) {
			return "∃" + ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(this);
		}

		@Override
		public String visit(OWLObjectAllValuesFrom ce) {
			return "∀" + ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(this);
		}

		@Override
		public String visit(OWLObjectHasValue ce) {
			return "∃" + ce.getProperty().accept(pvisitor) + ".{" + ce.getValue().accept(ivisitor) +"}";
		}

		@Override
		public String visit(OWLObjectMinCardinality ce) {
			return "≥number " + ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(this);
		}

		@Override
		public String visit(OWLObjectExactCardinality ce) {
			return "=number " + ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(this);
		}

		@Override
		public String visit(OWLObjectMaxCardinality ce) {
			return "≤number " + ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(this);
		}

		@Override
		public String visit(OWLObjectHasSelf ce) {
			return "Self";
		}

		@Override
		public String visit(OWLObjectOneOf ce) {
			String result = "";
	          boolean first = true;
	          for (OWLIndividual conjunct : ce.getIndividuals()) {
	                if (first) {
	                    result = "{" + conjunct.accept(ivisitor) + "}";
	                    first = false;
	                } else 
	                    result = result + " ⊔ " + "{" +conjunct.accept(ivisitor) + "}";
	            }
	           return "(" + result + ")";
		}

		@Override
		public String visit(OWLDataSomeValuesFrom ce) {
			return "∃" + ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(dvisitor);
		}

		@Override
		public String visit(OWLDataAllValuesFrom ce) {
			return "∀" + ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(dvisitor);
		}

		@Override
		public String visit(OWLDataHasValue ce) {
			return "∃" + ce.getProperty().accept(pvisitor) + ".{" + ce.getValue().accept(dvisitor) + "}"; 
		}

		@Override
		public String visit(OWLDataMinCardinality ce) {
			return "≥number " + ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(dvisitor);
		}

		@Override
		public String visit(OWLDataExactCardinality ce) {
			return "=number "+ ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(dvisitor);
		}

		@Override
		public String visit(OWLDataMaxCardinality ce) {
			return "≤number "+ ce.getProperty().accept(pvisitor) + "." + ce.getFiller().accept(dvisitor);
		}
    	
    }
    
    private class RoleVisitor implements OWLPropertyExpressionVisitorEx<String>{

    	@Override
    	public String visit(OWLObjectProperty arg0) {
    		// TODO Auto-generated method stub
    		int ident;
    		if (prop_distinc.containsKey(arg0.getIRI().getFragment())) {
    			ident = (int) prop_distinc.get(arg0.getIRI().getFragment());
    		}else {
    			prop_distinc.put(arg0.getIRI().getFragment(), it_prop);
    			ident = it_prop;
    			it_prop ++;
    		}
    		return "property_" + ident;
    	}

    	@Override
    	public String visit(OWLObjectInverseOf arg0) {
    		return "property" + "-";	
    	}

    	@Override
    	public String visit(OWLDataProperty arg0) {
    		// TODO Auto-generated method stub
    		int ident;
    		if (prop_distinc.containsKey(arg0.getIRI().getFragment())) {
    			ident = (int) prop_distinc.get(arg0.getIRI().getFragment());
    		}else {
    			prop_distinc.put(arg0.getIRI().getFragment(), it_prop);
    			ident = it_prop;
    			it_prop ++;
    		}
    		return "property_" + ident;
    	}

		@Override
		public String visit(OWLAnnotationProperty arg0) {
			int ident;
    		if (prop_distinc.containsKey(arg0.getIRI().getFragment())) {
    			ident = (int) prop_distinc.get(arg0.getIRI().getFragment());
    		}else {
    			prop_distinc.put(arg0.getIRI().getFragment(), it_prop);
    			ident = it_prop;
    			it_prop ++;
    		}
    		return "property_" + ident;
		}
    	
        }
    private class DataVisitor implements OWLDataVisitorEx<String>{

		@Override
		public String visit(OWLDatatype arg0) {
			// TODO Auto-generated method stub
			add_axiom = false;
			return "";
		}

		@Override
		public String visit(OWLDataComplementOf arg0) {
			// TODO Auto-generated method stub
			add_axiom = false;
			return "";
		}

		@Override
		public String visit(OWLDataOneOf arg0) {
			// TODO Auto-generated method stub
			add_axiom = false;
			return "";
		}

		@Override
		public String visit(OWLDataIntersectionOf arg0) {
			// TODO Auto-generated method stub
			add_axiom = false;
			return "";
		}

		@Override
		public String visit(OWLDataUnionOf arg0) {
			// TODO Auto-generated method stub
			add_axiom = false;
			return "";
		}

		@Override
		public String visit(OWLDatatypeRestriction arg0) {
			// TODO Auto-generated method stub
			add_axiom = false;
			return "";
		}

		@Override
		public String visit(OWLLiteral arg0) {
			// TODO Auto-generated method stub
			return "literal";
		}

		@Override
		public String visit(OWLFacetRestriction arg0) {
			// TODO Auto-generated method stub
			add_axiom = false;
			return "";
		}
    	
    }
    private class IndividualVisitor implements OWLIndividualVisitorEx<String>{

		@Override
		public String visit(OWLNamedIndividual arg0) {
			// TODO Auto-generated method stub
			int ident;
			if (indiv_distinc.containsKey(arg0.getIRI().getFragment())) {
				ident = (int) class_distinc.get(arg0.getIRI().getFragment());
			}else {
				class_distinc.put(arg0.getIRI().getFragment(), it_indiv);
				ident = it_indiv;
				it_indiv ++;
			}
			return "individual_" + ident;
		}

		@Override
		public String visit(OWLAnonymousIndividual arg0) {
			// TODO Auto-generated method stub
			add_axiom = false;
			return "";
		}
    	
    }
    
    private class AxiomVisitor implements OWLAxiomVisitorEx<String>{
		 

		@Override
		public String visit(OWLEquivalentClassesAxiom arg0) {
			return convert_equ(arg0);
		}

		@Override
		public String visit(OWLSubClassOfAxiom arg0) {
			return convert_sub(arg0);
		}
		
		@Override
		public String visit(OWLDisjointClassesAxiom arg0) {
			return convert_djc(arg0);
		}
		
		@Override
		public String visit(OWLSameIndividualAxiom arg0) {
			return convert_sin(arg0);
		}
		
		@Override
		public String visit(OWLEquivalentObjectPropertiesAxiom arg0) {
			return convert_eop(arg0);
		}
		
		@Override
		public String visit(OWLDifferentIndividualsAxiom arg0) {
			return convert_din(arg0);
		}	

		@Override
		public String visit(OWLSubObjectPropertyOfAxiom arg0) {
			return convert_sop(arg0);
		}	

		@Override
		public String visit(OWLClassAssertionAxiom arg0) {
			return convert_ca(arg0);
		}		

		@Override
		public String visit(OWLObjectPropertyAssertionAxiom arg0) {
			return convert_opa(arg0);
		}

		@Override
		public String visit(OWLDataPropertyAssertionAxiom arg0) {
			return convert_dpa(arg0);
		}

		@Override
		public String visit(OWLObjectPropertyDomainAxiom arg0) {
			return convert_opd(arg0);
		}
		

		@Override
		public String visit(OWLObjectPropertyRangeAxiom arg0) {
			return convert_opr(arg0);
		}

		@Override
		public String visit(OWLFunctionalObjectPropertyAxiom arg0) {
			return convert_fop(arg0);
		}
		
		@Override
		public String visit(OWLTransitiveObjectPropertyAxiom arg0) {
			return convert_top(arg0);
		}

		
		////////////////////
		////////////////////
		
		
		@Override
		public String visit(OWLSubAnnotationPropertyOfAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLAnnotationPropertyDomainAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLAnnotationPropertyRangeAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}


		@Override
		public String visit(OWLNegativeObjectPropertyAssertionAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLAsymmetricObjectPropertyAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLReflexiveObjectPropertyAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}


		@Override
		public String visit(OWLDataPropertyDomainAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLNegativeDataPropertyAssertionAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLDisjointDataPropertiesAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLDisjointObjectPropertiesAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLDisjointUnionAxiom arg0) {
			return "";
		}

		@Override
		public String visit(OWLDeclarationAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLAnnotationAssertionAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLSymmetricObjectPropertyAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLDataPropertyRangeAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLFunctionalDataPropertyAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLEquivalentDataPropertiesAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLIrreflexiveObjectPropertyAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLSubDataPropertyOfAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLInverseFunctionalObjectPropertyAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLSubPropertyChainOfAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLInverseObjectPropertiesAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLHasKeyAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(OWLDatatypeDefinitionAxiom arg0) {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public String visit(SWRLRule arg0) {
			// TODO Auto-generated method stub
			return "";
		}
		 
	 }
    
}
