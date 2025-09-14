/**
 * @since 2019-06-28 10:13
 * @author vivaxy
 */
import { getCurrentBranch } from '../branch';
import { getCurrentRemote } from '../remote';
import { Stdio, betterExeca } from '../helpers';

export default async function push({
  cwd,
  followTags = false,
  setUpstream = false,
  noVerify = false,
  stdio = 'inherit',
}: {
  cwd: string;
  followTags?: boolean;
  setUpstream?: boolean;
  noVerify?: boolean;
  stdio?: Stdio;
}) {
  const branch = await getCurrentBranch({ cwd });
  if (!branch) {
    throw new Error('Invalid branch');
  }
  const remote = await getCurrentRemote({ cwd });
  if (!remote) {
    throw new Error('Invalid remote');
  }
  const args = ['push'];
  if (followTags) {
    args.push('--follow-tags');
  }
  if (setUpstream) {
    args.push('--set-upstream');
  }
  args.push(remote, branch);
  if (noVerify) {
    args.push('--no-verify');
  }
  await betterExeca('git', args, {
    stdio,
    cwd,
  });
}
