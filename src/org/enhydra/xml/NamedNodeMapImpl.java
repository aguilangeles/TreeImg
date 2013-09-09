/*
 * @(#)HashMapNode.java 1.36 02/03/21
 *
 * Copyright 2002 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.enhydra.xml;

import java.util.Iterator;
import java.util.List;

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


/**
 * A class representing a node in a meta-data tree, which implements
 * the <a HREF="../../../../api/org/w3c/dom/NamedNodeMap.html">
 *
 * @version 1.0
 */

public class NamedNodeMapImpl implements NamedNodeMap {

    /**
     * List of <code>Node</code>s.
     */
    List nodes;


    /**
     * Constructs new <code>NamedNodeMapImpl</code> with the given list of nodes.
     *
     * @param nodes list of nodes.
     */
    public NamedNodeMapImpl(List nodes) {
        this.nodes = nodes;
    }

    /**
     * Returns the count of nodes.
     *
     * @return the count of nodes.
     */
    public int getLength() {
        return nodes.size();
    }


    /**
     * Returns the <code>Node</code> with the given name.
     *
     * @param name the node name.
     * @return the <code>Node</code> with the given name.
     */
    public Node getNamedItem(String name) {
        Iterator iter = nodes.iterator();
        while (iter.hasNext()) {
            Node node = (Node) iter.next();
            if (name.equals(node.getNodeName())) {
                return node;
            }
        }

        return null;
    }

    /**
     * Returns the <code>Node</code> with the given index.
     *
     * @param index index of a node.
     * @return the <code>Node</code> with the given index.
     */
    public Node item(int index) {
        Node node = (Node) nodes.get(index);
        return node;
    }


    /**
     * Modification of the items is not allowed !
     * Removes the item with the given name.
     *
     * @param name item name.
     * @return the <code>Node</code> with the given name.
     */
    public Node removeNamedItem(java.lang.String name) {
        throw new DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR, "This NamedNodeMap is read-only!");
    }


    /**
     * Modification of the items is not allowed !
     * Sets the item with the given name.
     *
     * @param arg <code>Node</code>.
     * @return Sets the item with the given name.
     */
    public Node setNamedItem(Node arg) {
        nodes.add(arg);
        return arg;
    }


    /**
     * Equivalent to <code>getNamedItem(localName)</code>.
     */
    public Node getNamedItemNS(String namespaceURI, String localName) {
        return getNamedItem(localName);
    }


    /**
     * Equivalent to <code>setNamedItem(arg)</code>.
     */
    public Node setNamedItemNS(Node arg) {
        return setNamedItem(arg);
    }


    /**
     * Equivalent to <code>removeNamedItem(localName)</code>.
     */
    public Node removeNamedItemNS(String namespaceURI, String localName) {
        return removeNamedItem(localName);
    }

    public List getNodes() {
        return nodes;
    }

    public Iterator getIterator() {
        return nodes.iterator();
    }

}

