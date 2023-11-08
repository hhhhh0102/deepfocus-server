package io.poten13.deepfocus.domain.user.service

import io.poten13.deepfocus.global.constants.Severity

class UpdateSeverityCommand(val userToken: String, val severity: Severity)