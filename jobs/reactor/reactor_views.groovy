package reactor

import javaposse.jobdsl.dsl.DslFactory

DslFactory dsl = this

dsl.listView('Seeds') {
	jobs {
		regex('.*-seed')
	}
	columns defaultColumns()
}

dsl.nestedView('Reactor') {
	views {
		listView('Releaser') {
			jobs {
				regex('reactor.*-releaser')
			}
			columns defaultColumns()
		}
		listView('All Reactor') {
			jobs {
				regex('reactor.*')
			}
			columns defaultColumns()
		}
	}
}

private Closure defaultColumns() {
	return {
		status()
		name()
		lastSuccess()
		lastFailure()
		lastBuildConsole()
		buildButton()
	}
}