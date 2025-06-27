package org.redtreasure.preppy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform