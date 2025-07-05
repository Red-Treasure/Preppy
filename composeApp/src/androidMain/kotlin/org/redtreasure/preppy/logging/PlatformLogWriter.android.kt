package org.redtreasure.preppy.logging

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.LogcatWriter

actual fun platformLogWriter(): LogWriter = LogcatWriter()