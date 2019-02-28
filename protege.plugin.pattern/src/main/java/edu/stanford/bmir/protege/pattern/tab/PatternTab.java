package edu.stanford.bmir.protege.pattern.tab;

import org.protege.editor.owl.ui.OWLWorkspaceViewsTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatternTab extends OWLWorkspaceViewsTab {

	private static final Logger log = LoggerFactory.getLogger(PatternTab.class);

	public PatternTab() {
		setToolTipText("Tool to extract and validate axiom pattern.");
	}

    @Override
	public void initialise() {
		super.initialise();
		log.info("Pattern Tab initialized");
	}

	@Override
	public void dispose() {
		super.dispose();
		log.info("Pattern Tab disposed");
	}
}
