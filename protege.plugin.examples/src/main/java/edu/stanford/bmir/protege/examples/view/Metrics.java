package edu.stanford.bmir.protege.examples.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

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
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

import edu.stanford.bmir.protege.examples.*;

public class Metrics extends JPanel {

    private JButton refreshButton = new JButton("Refresh");

    private JPanel panel = new JPanel();
    private OWLModelManager modelManager;

    private ActionListener refreshAction = e -> recalculate();
    
    private OWLModelManagerListener modelListener = event -> {
        if (event.getType() == EventType.ACTIVE_ONTOLOGY_CHANGED) {
            recalculate();
        }
    };
    
    public Metrics(OWLModelManager modelManager) {
    	this.modelManager = modelManager;
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	recalculate(); 
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(50, 30, 400, 500);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500, 400));
        contentPane.add(scrollPane);         
    	add(contentPane);
        modelManager.addListener(modelListener);
        refreshButton.addActionListener(refreshAction);
     }
    
    public void dispose() {
        modelManager.removeListener(modelListener);
        refreshButton.removeActionListener(refreshAction);
    }
    
    private void recalculate() {
        int count = modelManager.getActiveOntology().getClassesInSignature().size();
        if (count == 0) {
            count = 1;  // owl:Thing is always there.
        }
        for (OWLSubClassOfAxiom ax : modelManager.getActiveOntology().getAxioms(AxiomType.SUBCLASS_OF)) {
        	convertsubclass(panel, ax);
        }
    }
    
    private void convertsubclass(JPanel panel, OWLSubClassOfAxiom ax) {
    		String axiom = ax.toString();
        	JLabel textComponent = new JLabel();
        	textComponent.setText(axiom);
        	textComponent.setAlignmentX(Component.CENTER_ALIGNMENT);
        	panel.add(textComponent);
    }
}
