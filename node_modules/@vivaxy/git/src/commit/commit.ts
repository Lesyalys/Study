/**
 * @since 2019-06-28 09:59
 * @author vivaxy
 */
import { Stdio, betterExeca } from '../helpers';

export default async function commit(
  message: string,
  { cwd, noVerify = false, stdio = 'inherit' }: { cwd: string; noVerify?: boolean; stdio?: Stdio; },
): Promise<void> {
  const args = ['commit', '-m', message];
  if (noVerify) {
    args.push('--no-verify')
  }
  await betterExeca('git', args, { stdio, cwd });
}
