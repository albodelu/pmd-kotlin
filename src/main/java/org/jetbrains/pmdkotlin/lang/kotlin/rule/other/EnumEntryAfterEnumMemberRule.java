package org.jetbrains.pmdkotlin.lang.kotlin.rule.other;

import net.sourceforge.pmd.lang.ast.Node;
import org.jetbrains.kotlin.psi.JetEnumEntry;
import org.jetbrains.pmdkotlin.lang.kotlin.ast.KotlinASTNodeAdapter;
import org.jetbrains.pmdkotlin.lang.kotlin.rule.AbstractKotlinRule;

import static org.jetbrains.kotlin.resolve.DeclarationsChecker.enumEntryAfterEnumMember;
import static org.jetbrains.kotlin.resolve.DeclarationsChecker.enumEntryUsesDeprecatedSuperConstructor;

public class EnumEntryAfterEnumMemberRule extends AbstractKotlinRule {

    @Override
    public Object visitEnumEntryPMD(JetEnumEntry node, Object data) {
        if (enumEntryAfterEnumMember(node)) {
            addViolation(getSavedData(), node.<Node>getCopyableUserData(KotlinASTNodeAdapter.OUTER_NODE_KEY));
        }

        return super.visitEnumEntryPMD(node, data);
    }
}
