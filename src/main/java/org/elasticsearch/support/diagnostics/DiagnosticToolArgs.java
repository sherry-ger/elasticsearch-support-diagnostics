/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.support.diagnostics;

import com.lexicalscope.jewel.cli.Option;

import java.nio.file.Paths;

/**
 * {@code DiagnosticToolArgs} is representative of <em>all</em> command line arguments that can be supplied.
 * <p />
 * An instance of this {@code interface} is generated by a {@code CliFactory}. No {@code class} implementation needs to
 * be created to represent this {@code interface}.
 */
public interface DiagnosticToolArgs {
    /**
     * Get the help dialog.
     *
     * @return {@code true} if requested (if used, this will always trigger an exception).
     */
    @Option(description = "This help message",
            helpRequest = true,
            shortName = { "h", "?" })
    boolean getHelp();

    /**
     * Get the host and port to use communicate with Elasticsearch.
     * <p />
     * Default: "localhost:9200"
     *
     * @return Never blank.
     */
    @Option(defaultValue = "localhost:9200",
            description = "Elasticsearch hostname:port .Defaults: localhost:9200 (optional)",
            exactly = 1,
            pattern = "\\S+:\\d{1,5}$",
            shortName = "H")
    String getHostPort();

    /**
     * Get the target node's name used to communicate with Elasticsearch.
     * <p />
     * Default: "_local"
     *
     * @return Never blank.
     */
    @Option(defaultValue = "_local",
            description = "On a host with multiple nodes, specify the node name to gather data for. Value should match node.name as defined in elasticsearch.yml (optional)",
            exactly = 1,
            pattern = ".+",
            shortName = "n")
    String getNodeName();

    /**
     * Get the output directory to use in place of the automatic value.
     * <p />
     * Default: null
     * <p />
     * If unset, this value will be used as "./support-diagnostics.[hostname].[node].[timestamp]".
     *
     * @return Can be {@code null}.
     * @see Paths#get(String, String...)
     */
    @Option(defaultToNull = true,
            description = "The optional output directory to use instead of './support-diagnostics.[hostname].[node].[timestamp]' (optional)",
            exactly = 1,
            shortName = "o")
    String getOutputDirectory();

    /**
     * Number of collection runs
     * <p />
     * Default: 1
     * <p />
     *
     * @return Never blank.
     */
    @Option(defaultToNull = true,
            description = "Number of times to collect stats. Default: 1 (optional)",
	    pattern = "^[1-9][0-9]*$",
            exactly = 1,
            shortName = "r")
    Integer getStatRuns();

    /**
     * Delay between interval runs
     * <p />
     * Default: 60
     * <p />
     *
     * @return Never blank.
     */
    @Option(defaultToNull = true,
            description = "Interval in seconds between stats collections. Default: 60. (optional)",
	    pattern = "^[1-9][0-9]*$",
            exactly = 1,
            shortName = "i")
    Integer getStatInterval();

    /**
     * Auth type
     * <p />
     * Default: null
     * <p />
     *
     * @return Never blank.
     */
    @Option(defaultToNull = true,
            description = "Authentication type. Either 'basic' or 'cookie'. Default: none. (optional)",
            exactly = 1,
            shortName = "a")
    String getAuthType();


    /**
     * Auth creds
     * <p />
     * Default: null
     * <p />
     *
     * @return Never blank.
     */
    @Option(defaultToNull = true,
            description = "Authentication credentials. Either a path to the auth cookie file or the basic auth usename. You will be prompted for the password unless you specify -p. Default: none. (optional)",
            exactly = 1,
            shortName = "c")
    String getAuthCreds();

    /**
     * Password for auth
     * <p />
     * Default: null
     * <p />
     *
     * @return Never blank.
     */
    @Option(defaultToNull = true,
            description = "Password for authentication. To be used with -c if having this script prompt for a password is undesiarable. Default: none. (optional)",
            exactly = 1,
            shortName = "a")
    String getAuthPassword();

}
