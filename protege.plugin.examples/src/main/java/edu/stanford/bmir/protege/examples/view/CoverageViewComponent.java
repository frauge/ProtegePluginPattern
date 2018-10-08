package edu.stanford.bmir.protege.examples.view;

import java.awt.BorderLayout;
import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoverageViewComponent extends AbstractOWLViewComponent {

    private static final Logger log = LoggerFactory.getLogger(CoverageViewComponent.class);

    private CompareOntologies compareComponent;

    @Override
    protected void initialiseOWLView() throws Exception {
        setLayout(new BorderLayout());
        compareComponent = new CompareOntologies(getOWLModelManager());
        add(compareComponent, BorderLayout.CENTER);
        log.info("Compare Component initialized");
    }

	@Override
	protected void disposeOWLView() {
		compareComponent.dispose();
	}
}
