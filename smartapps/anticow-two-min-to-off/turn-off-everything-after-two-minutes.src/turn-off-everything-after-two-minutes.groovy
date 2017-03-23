/**
 *  turn off everything after two minutes
 *
 *  Copyright 2017 Jim
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "turn off everything after two minutes",
    namespace: "anticow-two_min_to_off",
    author: "Jim",
    description: "turns off multiple devices after two minutes",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png") {
    appSetting "set lights"
    appSetting "set lights"
}


preferences {
	section("Turn off a switch in 3 minutes..."){
		input "Living room", "capability.switch"
	}
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	// TODO: subscribe to attributes, devices, locations, etc.
}

// TODO: implement event handlers

def contactOpenHandler(evt) {
	
	def fiveMinuteDelay = 60 * 3
	runIn(fiveMinuteDelay, turnOffSwitch)
}

def turnOffSwitch() {
	Downstairs.off()
}
