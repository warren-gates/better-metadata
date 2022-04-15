/*
 * Copyright (c) 2022. Warren Gates
 * All rights reserved.
 */

package dev.warrengates.bettermetadata

enum class IsAutoIncrement(override val value: String) : StringEnum {
    YES("YES"),
    NO("NO"),
    UNKNOWN("");
}