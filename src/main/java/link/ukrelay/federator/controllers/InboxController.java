package link.ukrelay.federator.controllers;

import link.ukrelay.federator.Config;
import link.ukrelay.federator.exceptions.InvalidSignatureException;
import link.ukrelay.federator.exceptions.MissingActorException;
import link.ukrelay.federator.exceptions.MissingSignatureException;
import link.ukrelay.federator.model.APRequest;
import link.ukrelay.federator.model.Signature;
import link.ukrelay.federator.services.InstanceService;
import link.ukrelay.federator.services.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inbox")
public class InboxController {

    private final Config config;

    private final InstanceService instanceService;

    private final SignatureService signatureService;

    public InboxController(@Autowired final Config config,
                           @Autowired final SignatureService signatureService,
                           @Autowired final InstanceService instanceService) {
        this.config = config;
        this.signatureService = signatureService;
        this.instanceService = instanceService;

        signatureService.getKey();
    }

    public String createSignature() {
        var signature = "Signature: keyId=\"%s\",headers=\"(request-target) host date\",signature=\"...\"";

        var keyId = config.getBaseurl()+"/actor#main-key";
        return signature.formatted(keyId);
    }

    @PostMapping(consumes = "application/activity+json")
    public String inbox(@RequestHeader(value = "signature", required = false) final String signature,
                        @RequestBody final APRequest request) {

        if (!StringUtils.hasText(signature)) {
            throw new MissingSignatureException();
        }

        final Signature sig;
        sig = this.signatureService.parseSignature(signature);

        if (!StringUtils.hasText(request.getActor())) {
            throw new MissingActorException();
        }



        /*
        actor = await misc.request(signature.keyid)
        software = await misc.fetch_nodeinfo(actor.domain)

	## reject if actor is empty
        if not actor:
        logging.verbose(f'Failed to fetch actor: {actor.id}')
        return Response.new_error(400, 'failed to fetch actor', 'json')

	## reject if the actor isn't whitelisted while the whiltelist is enabled
        elif config.whitelist_enabled and not config.is_whitelisted(actor.domain):
        logging.verbose(f'Rejected actor for not being in the whitelist: {actor.id}')
        return Response.new_error(403, 'access denied', 'json')

	## reject if actor is banned
        if request.app['config'].is_banned(actor.domain):
        logging.verbose(f'Ignored request from banned actor: {actor.id}')
        return Response.new_error(403, 'access denied', 'json')

	## reject if software used by actor is banned
        if config.is_banned_software(software):
        logging.verbose(f'Rejected actor for using specific software: {software}')
        return Response.new_error(403, 'access denied', 'json')

	## reject if the signature is invalid
        if not (await misc.validate_signature(actor, signature, request)):
        logging.verbose(f'signature validation failed for: {actor.id}')
        return Response.new_error(401, 'signature check failed', 'json')

	## reject if activity type isn't 'Follow' and the actor isn't following
        if data['type'] != 'Follow' and not database.get_inbox(actor.domain):
        logging.verbose(f'Rejected actor for trying to post while not following: {actor.id}')
        return Response.new_error(401, 'access denied', 'json')

        logging.debug(f">> payload {data}")

        await run_processor(request, actor, data, software)
        return Response.new(status=202)


*/
        return "OK: " + request.getActor();

    }

}
