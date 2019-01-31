package com.oc.programmer.objectives.localization;

/**
 * A resource bundle file could be a properties file or a class file.  The abstract class
 * ResourceBundle has two subclasses: PropertyResourceBundle and ListResourceBundle.
 *
 * A PropertyResourceBundle is backed by a properties file. A properties file is a plain-text file
 * that contains translatable text. Properties files are not part of the Java source code, and they
 * can contain values for String objects only. If you need to store other types of objects, use a
 * ListResourceBundle instead.
 *
 * The ListResourceBundle class manages resources with a convenient
 * list. Each ListResourceBundle is backed by a class file. You can store any locale-specific object
 * in a ListResourceBundle. To add support for an additional Locale, you create another source file
 * and compile it into a class file.
 *
 * The ResourceBundle class is flexible. If you first put your locale-specific String objects in a
 * PropertyResourceBundle and then later decided to use ListResourceBundle instead, there is no impact on your code.
 *
 * For example, the following call to getBundle will retrieve a ResourceBundle for the appropriate Locale,
 * whether ButtonLabel is backed up by a class or by a properties file:
 * ResourceBundle introLabels = ResourceBundle.getBundle("ButtonLabel", currentLocale);
 */
public class ResourceProperties {

}
