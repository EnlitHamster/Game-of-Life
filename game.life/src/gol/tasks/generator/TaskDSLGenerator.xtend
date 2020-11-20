/*
 * generated by Xtext 2.23.0
 */
package gol.tasks.generator

import gol.tasks.taskDSL.Model
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class TaskDSLGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val root = resource.allContents.head as Model;
		if (root !== null)
			fsa.generateFile("TextRep.txt", TextGenerator.toText(root))
	}
}