package org.apache.maven.cli.logging.impl;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;

import org.apache.maven.cli.logging.AbstractSlf4jConfiguration;
import org.apache.maven.cli.logging.Slf4jConfiguration;
import org.apache.maven.execution.MavenExecutionRequest;
import org.codehaus.plexus.component.annotations.Component;

/**
 * Configuration for slf4j-simple.
 * 
 * @author Hervé Boutemy
 */
@Component( role = Slf4jConfiguration.class )
public class Slf4jSimpleConfiguration
    extends AbstractSlf4jConfiguration
{
    public void setRootLoggerLevel( int level )
    {
        String value = "info";
        switch ( level )
        {
            case MavenExecutionRequest.LOGGING_LEVEL_DEBUG:
                value = "debug";
                break;
            
            case MavenExecutionRequest.LOGGING_LEVEL_INFO:
                value = "info";
                break;

            case MavenExecutionRequest.LOGGING_LEVEL_ERROR:
                value = "error";
                break;
        }
        System.setProperty( "org.slf4j.simpleLogger.defaultLogLevel", value );
    }

    public void setLoggerFile( File output )
    {
        System.setProperty( "org.slf4j.simpleLogger.logFile", output.getAbsolutePath() );
    }
}
