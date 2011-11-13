/*
 * The MIT License
 *
 * Copyright (c) 2004-2010, Sun Microsystems, Inc., Kohsuke Kawaguchi,
 * Erik Ramfelt, Koichi Fujikawa, Red Hat, Inc., Seiji Sogabe,
 * Stephen Connolly, Tom Huybrechts, Yahoo! Inc., Alan Harder, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkins.tools.test.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * POJO describing a versioned plugin
 * @author Frederic Camblor
 */
public class PluginInfos implements Comparable<PluginInfos> {
    public final String pluginName;
    public final String pluginVersion;
    public final String pluginUrl;

    public PluginInfos(String pluginName, String pluginVersion, String pluginUrl){
        this.pluginName = pluginName;
        this.pluginVersion = pluginVersion;
        this.pluginUrl = pluginUrl;
    }

    public boolean equals(Object o){
        if(o==null || !(o instanceof PluginInfos)){
            return false;
        }
        PluginInfos infos = (PluginInfos)o;
        return new EqualsBuilder().append(pluginName, infos.pluginName).append(pluginVersion, infos.pluginVersion).isEquals();
    }

    public int hashCode(){
        return new HashCodeBuilder().append(pluginName).append(pluginVersion).toHashCode();
    }

    public int compareTo(PluginInfos o) {
        if(pluginName.equals(o.pluginName)){
            return pluginVersion.compareTo(o.pluginVersion);
        }else{
            return pluginName.compareToIgnoreCase(o.pluginName);
        }
    }
}
