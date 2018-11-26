package edu.stanford.bmir.protege.examples.view;

import java.awt.BorderLayout;
import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtractionViewComponent extends AbstractOWLViewComponent {

    private static final Logger log = LoggerFactory.getLogger(ExtractionViewComponent.class);

    private ExtractOntology Component;

    @Override
    protected void initialiseOWLView() throws Exception {
        setLayout(new BorderLayout());
        Component = new ExtractOntology(getOWLModelManager());
        add(Component, BorderLayout.CENTER);
        log.info("Extraction Component initialized");
    }

	@Override
	protected void disposeOWLView() {
		Component.dispose();
	}
}
